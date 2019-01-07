package com.example.springboot.mybatis;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.UnknownTypeHandler;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@Intercepts({@Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class}),
            @Signature(type = Executor.class,
            method = "query",
            args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
@Component
public class PageInterceptor implements Interceptor {

    /*
    分页问题：
    1.效率：粗暴的用子查询，效率慢，但简单
        解决：
        * 1)分情况处理，如果有分组函数，group by，distinct等，则用子查询，否则直接使用select count(1) from替换原from前sql；
        * 2)自定义查询sql，Interceptor中检测如果有自定义则优先使用——PageHelper后面更新的版本使用的这样的方式；
    2.缓存：当在同一个事务中时，mybatis相同的接口会直接使用缓存中数据
        解决：
        * 1)修改Interceptor位置，在prepare中由于缓存逻辑先进行，是没办法拦截的，如果拦截query则可以判断分页参数来决定缓存逻辑
        * 2)不处理，同一个请求中，需要连续分页的逻辑基本没有，但要记住这里有个坑
        * 3)直接不启用mybatis缓存，但有点本末倒置了
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            Integer pageNo = PageHelper.getPage();
            Integer pageSize = PageHelper.getPageSize();
            if(pageNo == null || pageSize == null){
                return invocation.proceed();
            }

            if(invocation.getTarget() instanceof Executor){
                //修改MappedStatement.id，确保缓存与分页关联
                MappedStatement ms = (MappedStatement)invocation.getArgs()[0];
                SystemMetaObject.forObject(ms).setValue("id",ms.getId()+pageNo+pageSize);
                return invocation.proceed();
            }
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            BoundSql sql = statementHandler.getBoundSql();
            System.out.println("sql:" + sql.getSql());
            MappedStatement mappedStatement = (MappedStatement) SystemMetaObject.forObject(statementHandler)
                    .getValue("delegate.mappedStatement");

            String countSql = "select count(1) from (" + sql.getSql() + ") t";
            System.out.println("count sql:" + sql.getSql());
            Connection conn = (Connection) invocation.getArgs()[0];
            PreparedStatement pstmt = conn.prepareStatement(countSql);
            for (int i = 0; i < sql.getParameterMappings().size(); i++) {
                ParameterMapping pm = sql.getParameterMappings().get(i);
                pstmt.setObject(i + 1, ((Map) (sql.getParameterObject())).get(pm.getProperty()));
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                long totalCount = rs.getBigDecimal(1).longValue();
                PageHelper.setTotal(totalCount);
            } else {
                PageHelper.setTotal(0L);
            }
            String newSql = sql.getSql() + " limit "+(pageNo-1)*pageSize+","+pageSize;

            SystemMetaObject.forObject(sql).setValue("sql",newSql);

            return invocation.proceed();
        }finally {
            PageHelper.clear();
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
