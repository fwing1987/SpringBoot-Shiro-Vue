package com.example.springboot.dao;

import com.example.springboot.entity.SysUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface SysUserDao extends CrudRepository<SysUserEntity,Integer>,BaseDao<SysUserEntity,Integer> {
}
