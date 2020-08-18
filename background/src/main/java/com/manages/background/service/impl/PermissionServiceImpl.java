package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.PermissionMapper;
import com.manages.background.pojo.Permission;
import com.manages.background.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * @author lbk
 * @date 2020/8/3 9:32
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> list(Set<Long> ids) {

        return null;
    }

    @Override
    public List<Permission> PermissionByRoleId(Set<Long> ids) {
        List<Permission> list = permissionMapper.PermissionByRoleId(ids);
        return list;
    }

    @Override
    public List<Permission> lists(Long id) {
        List<Permission> list = permissionMapper.list(id);
        return list;
    }
}
