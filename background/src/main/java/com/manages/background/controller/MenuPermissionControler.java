package com.manages.background.controller;

import com.manages.background.pojo.MenuPermission;
import com.manages.background.service.impl.MenuPermissionServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 16:29
 **/
@RestController
@RequestMapping("menuPermission")
public class MenuPermissionControler {

    @Autowired
    MenuPermissionServiceImpl menuPermissionService;

    @PostMapping("add")
    public ResultJson add(MenuPermission menuPermission){
        menuPermissionService.save(menuPermission);
        return ResultJson.returnOK(menuPermission);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(menuPermissionService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(MenuPermission menuPermission){
        return ResultJson.returnOK(menuPermissionService.updateById(menuPermission));
    }

    @GetMapping("list")
    public ResultJson list(){
       List<MenuPermission> list = menuPermissionService.list();
       return ResultJson.returnOK(list);
    }

}
