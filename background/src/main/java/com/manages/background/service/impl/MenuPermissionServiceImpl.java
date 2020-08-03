package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.MenuPermissionMapper;
import com.manages.background.pojo.MenuPermission;
import com.manages.background.service.MenuPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/8/3 16:28
 **/
@Service
public class MenuPermissionServiceImpl extends ServiceImpl<MenuPermissionMapper, MenuPermission> implements MenuPermissionService {
}
