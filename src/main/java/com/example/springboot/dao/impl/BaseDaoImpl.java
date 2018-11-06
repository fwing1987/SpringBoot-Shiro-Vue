package com.example.springboot.dao.impl;

import com.example.springboot.dao.BaseDao;
import jdk.nashorn.internal.runtime.options.Option;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by apple on 2018/4/23.
 */
@Transactional
public class BaseDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseDao<T,ID> {

    private EntityManager entityManager;


    public BaseDaoImpl(JpaEntityInformation entityInformation,
                              EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public Session getSession(){
        return entityManager.unwrap(Session.class);
    }

    public Optional<T> findByIdWithLock(ID id){
        return Optional.ofNullable(getSession().get(getDomainClass(),id, LockMode.PESSIMISTIC_WRITE));
    }

    private NativeQuery createSqlQuery(String sql , Object... values){
        NativeQuery query = getSession().createNativeQuery(sql);
        for(int i = 0;i < values.length;++i){
            query.setParameter(i + 1,values[i]);
        }
        return query;

    }

    @SuppressWarnings("unchecked")
    public List<T> findBySql(String sql, Object... values){
        return createSqlQuery(sql,values).addEntity(getDomainClass()).list();
    }

    public List findMapBySql(String sql,Object... values){
        return createSqlQuery(sql,values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    public List findListBySql(String sql,Object... values){
        return createSqlQuery(sql,values).getResultList();
    }

    public Object findUniqueMapBySql(String sql,Object... values){
        return createSqlQuery(sql,values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
    }

    private Query<T> createCriteria(Map<String,Object> params){
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getDomainClass());
        Root<T> root = cq.from(getDomainClass());

        for(Map.Entry<String,Object> entry : params.entrySet()) {
            cq.where(cb.equal(root.get(entry.getKey()), entry.getValue()));
        }

        return getSession().createQuery(cq);
    }

    public List<T> findByProperty(String prop,Object value){
        return createCriteria(Collections.singletonMap(prop,value)).getResultList();
    }

    public T findUniqueByProperty(String prop,Object value){
        try{
            return createCriteria(Collections.singletonMap(prop,value)).getSingleResult();
        }catch (Exception e){
        }
        return null;
    }

    public void executeUpdateSql(String sql){
        this.getSession().createNativeQuery(sql).executeUpdate();
    }

    public int executeUpdateSqlWithReturn(String sql){
        return this.getSession().createNativeQuery(sql).executeUpdate();
    }

    public int executeUpdateSqlWithReturn(String sql,Object... values){
        return createSqlQuery(sql,values).executeUpdate();
    }
}