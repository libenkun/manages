package com.manages.background.controller;

/**
 * @author lbk
 * @date 2020/7/31 14:12
 **/

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manages.background.pojo.Menu;
import com.manages.background.pojo.Permission;
import com.manages.background.pojo.Role;
import com.manages.background.pojo.User;
import com.manages.background.service.impl.MenuServiceImpl;
import com.manages.background.service.impl.PermissionServiceImpl;
import com.manages.background.service.impl.RoleServiceImpl;
import com.manages.background.service.impl.UserServiceImpl;
import com.manages.background.utils.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
@Slf4j
public class UserControler {

    @Autowired
    UserServiceImpl userService;
    @Resource
    RoleServiceImpl roleService;

    @Autowired
    PermissionServiceImpl permissionService;

    @Autowired
    MenuServiceImpl menuService;


    @PostMapping("login")
    public ResultJson login(@RequestBody User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword());

        //1查询用户信息
        User loginUser = userService.getOne(queryWrapper);
        if (Objects.isNull(loginUser)) {
            return ResultJson.returnError("用户为空！");
        }
        //2通过用户id，查询出角色信息
        List<Role> roleList = roleService.list(loginUser.getId());
        if (!roleList.isEmpty()) {
            Set<Long> ids = roleList.parallelStream().map(Role::getId).collect(Collectors.toSet());
            //3通过角色信息，拿到权限
            List<Permission> permissionList = permissionService.PermissionByRoleId(ids);
            Set<Long> permissionIds = permissionList.stream().map(Permission::getId).collect(Collectors.toSet());
            //4通过权限信息，拿到菜单信息
            List<Menu> menuList = menuService.menuList(permissionIds);
            if (!menuList.isEmpty()) {
                loginUser.setMenus(menuList);
            } else {
                loginUser.setMenus(new ArrayList<>());
            }
        }
        return ResultJson.returnOK(loginUser);
    }

    @PostMapping("add")
    public ResultJson add(@RequestBody User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        List<User> list = userService.list(queryWrapper);
        if (!list.isEmpty()) {
            return ResultJson.returnError("用户名重复！");
        } else {
            userService.save(user);
            return ResultJson.returnOK(user);
        }
    }

    @PostMapping("update")
    public ResultJson update(@RequestBody User user) {
        userService.updateById(user);
        return ResultJson.returnOK("修改成功！");
    }

    @DeleteMapping("remover/{id}")
    public ResultJson remover(@PathVariable("id") Long id) {
        userService.removeById(id);
        return ResultJson.returnOK("删除成功！");
    }

    @GetMapping("list")
    public ResultJson list() {
        return ResultJson.returnOK(userService.list());
    }

    @GetMapping("page")
    public ResultJson page(Page<User> page, User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(user.getUsername())) {
            queryWrapper.like(User::getUsername, user.getUsername());
        }
        return ResultJson.returnOK(userService.page(page, queryWrapper));
    }

    @GetMapping("userById/{id}")
    public ResultJson userById(@PathVariable("id") Long id) {
        return ResultJson.returnOK(userService.getById(id));
    }

}
