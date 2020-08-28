package com.manages.background.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manages.background.pojo.User;
import com.manages.background.pojo.UserRole;
import com.manages.background.service.impl.RoleServiceImpl;
import com.manages.background.service.impl.UserRoleServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lbk
 * @date 2020/8/3 11:33
 **/
@RestController
@RequestMapping("userRole")
public class UserRoleControler {

    @Autowired
    UserRoleServiceImpl userRoleService;

    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("add")
    public ResultJson add(UserRole userRole){
        userRoleService.save(userRole);
        return ResultJson.returnOK(userRole);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(userRoleService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(UserRole userRole){

        return ResultJson.returnOK(userRoleService.updateById(userRole));
    }

    @GetMapping("list")
    public ResultJson list(){
        List<UserRole> list = userRoleService.list();
        return ResultJson.returnOK(list);
    }

    @GetMapping("userRole/{userId}")
    public ResultJson userRole(@PathVariable("userId") Long userId){
            return ResultJson.returnOK(roleService.list(userId));
    }

    @PostMapping("updateByRoleId")
    public ResultJson updateByRoleId(@RequestBody UserRole userRole){
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId,userRole.getUserId());
        UserRole ur = userRoleService.getOne(queryWrapper);
        if (Objects.nonNull(ur)){
            UserRole uRole = new UserRole();
            uRole.setRoleId(userRole.getRoleId());
            uRole.setUserId(userRole.getUserId());
            uRole.setId(ur.getId());
            userRoleService.updateById(uRole);
            return ResultJson.returnOK("修改成功");
        }else {
            userRoleService.save(userRole);
            return ResultJson.returnOK("保存成功！");
        }
    }


}
