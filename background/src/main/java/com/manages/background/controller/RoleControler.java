package com.manages.background.controller;

import com.manages.background.pojo.Role;
import com.manages.background.service.impl.RoleServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 10:26
 **/
@RestController
@RequestMapping("role")
public class RoleControler {

    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("add")
    public ResultJson add(@RequestBody Role role){
        roleService.save(role);
        return ResultJson.returnOK(role);
    }

    @DeleteMapping("remover/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(roleService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(@RequestBody Role role){
        return ResultJson.returnOK(roleService.updateById(role));
    }

    @GetMapping("list")
    public ResultJson list(){
        List<Role> list = roleService.list();
        return ResultJson.returnOK(list);
    }

    @GetMapping("getRole/{id}")
    public ResultJson getRole(@PathVariable("id") Long id){
        return ResultJson.returnOK(roleService.getById(id));
    }
}
