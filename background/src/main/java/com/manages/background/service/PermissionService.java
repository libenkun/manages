package com.manages.background.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manages.background.pojo.Permission;
import java.util.List;
import java.util.Set;

/**
 * @author lbk
 * @date 2020/8/3 9:28
 **/
public interface PermissionService extends IService<Permission> {

    List<Permission> PermissionByRoleId(Set<Long> ids);
    List<Permission> lists(Long id);
}
