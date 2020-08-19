package com.manages.background.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manages.background.pojo.Permission;
import com.manages.background.service.impl.PermissionServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("tree")
    public ResultJson tree(){
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Permission::getPid,0);
        List<Permission> list = permissionService.list(queryWrapper);
        if (!list.isEmpty()){
            list.stream().forEach(i->{
                LambdaQueryWrapper<Permission> query = new LambdaQueryWrapper<>();
                query.eq(Permission::getPid,i.getId());
                List<Permission> ss = permissionService.list(query);
                i.setPermissionList(ss);
            });
        }
        return ResultJson.returnOK(list);
    }
}
