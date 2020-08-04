package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.RoleMapper;
import com.manages.background.pojo.Role;
import com.manages.background.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 9:34
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> list(Long userId){
            List<Role> roles = roleMapper.roleListByUserId(userId);
            return roles;
    }

}
