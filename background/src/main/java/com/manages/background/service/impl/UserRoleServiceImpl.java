package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.UserRoleMapper;
import com.manages.background.pojo.UserRole;
import com.manages.background.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/8/3 9:35
 **/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
