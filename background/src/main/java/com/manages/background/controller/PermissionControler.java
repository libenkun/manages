package com.manages.background.controller;

import com.manages.background.pojo.Permission;
import com.manages.background.service.impl.PermissionServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lbk
 * @date 2020/8/3 9:44
 **/
@RestController
@RequestMapping("permission")
public class PermissionControler {

    @Autowired
    PermissionServiceImpl permissionService;

    @PostMapping("add")
    public ResultJson add(@RequestBody Permission permission){
        permissionService.save(permission);
        return ResultJson.returnOK(permission);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(permissionService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(Permission permission){
        return ResultJson.returnOK(permissionService.updateById(permission));
    }

    @GetMapping("list")
    public ResultJson list(){
        return ResultJson.returnOK(permissionService.list());
    }
}
