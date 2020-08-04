package com.manages.background.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manages.background.pojo.Permission;
import com.manages.background.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author lbk
 * @date 2020/8/3 9:23
 **/
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> PermissionList(@Param("ids") Set<Long> ids);
    List<Permission> PermissionByRoleId(@Param("ids") Set<Long> ids);
}
