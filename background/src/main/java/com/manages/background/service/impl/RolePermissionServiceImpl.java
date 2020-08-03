package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.RolePermissionMapper;
import com.manages.background.pojo.RolePermission;
import com.manages.background.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/8/3 9:33
 **/
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
}
