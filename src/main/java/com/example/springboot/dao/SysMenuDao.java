package com.example.springboot.dao;

import com.example.springboot.entity.SysMenuEntity;
import org.springframework.data.repository.CrudRepository;

public interface SysMenuDao extends CrudRepository<SysMenuEntity,Integer>,BaseDao<SysMenuEntity,Integer> {
}
