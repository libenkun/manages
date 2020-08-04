package com.manages.background.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manages.background.pojo.Role;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 9:28
 **/
public interface RoleService extends IService<Role> {
     List<Role> list(Long userId);
}
