package com.manages.background.controller;

/**
 * @author lbk
 * @date 2020/7/31 14:12
 **/

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manages.background.pojo.User;
import com.manages.background.service.impl.UserServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserControler {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("login")
    public ResultJson login(User user){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername())
                    .eq(User::getPassword,user.getPassword());

       User loginUser = userService.getOne(queryWrapper);
        if (Objects.nonNull(loginUser)){
            return ResultJson.returnOK(loginUser);
        }else {
            return ResultJson.returnError("不是系统用户！");
        }
    }

    @PostMapping("add")
    public ResultJson add(User user){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        List<User> list = userService.list(queryWrapper);
        if (!list.isEmpty()){
            return ResultJson.returnError("用户名重复！");
        }else {
            userService.save(user);
            return ResultJson.returnOK(user);
        }
    }

    @PutMapping("update")
    public ResultJson update(User user){
        userService.updateById(user);
        return ResultJson.returnOK("修改成功！");
    }

    @DeleteMapping("remover/{id}")
    public ResultJson remover(@PathVariable("id") Long id){
        userService.removeById(id);
        return ResultJson.returnOK("删除成功！");
    }

    @GetMapping("list")
    public ResultJson list(){
       return ResultJson.returnOK(userService.list());
    }
}
