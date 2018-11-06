package com.example.springboot.dao;

import org.hibernate.Session;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by apple on 2018/4/23.
 */
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> {

    public Optional<T> findByIdWithLock(ID id);

    public List<T> findBySql(String sql, Object... values);

    public List findMapBySql(String sql, Object... values);

    public Object findUniqueMapBySql(String sql, Object... values);

    public List findListBySql(String sql,Object... values);

    public List<T> findByProperty(String prop, Object value);

    public T findUniqueByProperty(String prop, Object value);

    public void executeUpdateSql(String sql);

    public int executeUpdateSqlWithReturn(String sql);
    public int executeUpdateSqlWithReturn(String sql, Object... values);
}