package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.RoleMapper;
import com.manages.background.pojo.Role;
import com.manages.background.service.RoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            if (roles.isEmpty()){
                List<Role> isNull = new ArrayList<>();
                return isNull;
            }else {
                return roles;
            }
    }

}
