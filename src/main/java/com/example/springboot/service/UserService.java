package com.example.springboot.service;

import com.example.springboot.dao.SysUserDao;
import com.example.springboot.entity.SysUserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class UserService {
    @Resource
    SysUserDao sysUserDao;

    public SysUserEntity findUserByName(String username){
        SysUserEntity user = sysUserDao.findUniqueByProperty("username",username);
        if(user == null){
            return null;
        }
        String sql = "select rolename " +
                "from sys_role r,sys_user_role ur,sys_user u " +
                "where r.id=ur.role_id and u.id=ur.user_id and u.id="+user.getId();

        List<String> roleList = sysUserDao.findListBySql(sql);


        sql = "select permission_code " +
                "from sys_role r,sys_user_role ur,sys_user u,sys_role_permission rp,sys_permission p " +
                "where r.id=ur.role_id and u.id=ur.user_id and rp.role_id=r.id and rp.permission_id=p.id and u.id="+user.getId();

        List<String> permissionList = sysUserDao.findListBySql(sql);

        sql = "select menu_path,menu_name " +
                "from sys_role r,sys_user_role ur,sys_user u,sys_role_menu rm,sys_menu m " +
                "where r.id=ur.role_id and u.id=ur.user_id and rm.role_id=r.id and rm.menu_id=m.id and u.id="+user.getId();

        List<Map<String,Object>> menuList = sysUserDao.findMapBySql(sql);

        user.setRoleList(roleList);
        user.setPermissionList(permissionList);
        user.setMenuList(menuList);
        return user;
    }
}
