package com.manages.background.controller;

import com.manages.background.pojo.RolePermission;
import com.manages.background.service.impl.RolePermissionServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 10:36
 **/
@RequestMapping("rolePermission")
@RestController
public class RolePermissionControler {

    @Autowired
    RolePermissionServiceImpl rolePermissionService;


    @PostMapping("add")
    public ResultJson add(RolePermission rolePermission){
        rolePermissionService.save(rolePermission);
        return ResultJson.returnOK(rolePermission);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(rolePermissionService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(RolePermission rolePermission){
        return ResultJson.returnOK(rolePermissionService.updateById(rolePermission));
    }

    @GetMapping("list")
    public ResultJson list(){
        List<RolePermission> list = rolePermissionService.list();
        return ResultJson.returnOK(list);
    }


}
