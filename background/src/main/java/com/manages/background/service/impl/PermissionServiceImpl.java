package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.PermissionMapper;
import com.manages.background.pojo.Permission;
import com.manages.background.service.PermissionService;
import org.springframework.stereotype.Service;


/**
 * @author lbk
 * @date 2020/8/3 9:32
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
