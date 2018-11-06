package com.example.springboot.dao;


import com.example.springboot.entity.DnPromotionInfoEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apple on 2018/4/24.
 */
public interface DnPromotionInfoDao extends CrudRepository<DnPromotionInfoEntity,Integer>,BaseDao<DnPromotionInfoEntity,Integer>{
}
