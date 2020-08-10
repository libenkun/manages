package com.manages.background.controller;

import com.manages.background.pojo.Menu;
import com.manages.background.service.impl.MenuServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lbk
 * @date 2020/8/3 9:37
 **/
@RestController
@RequestMapping("menu")
public class MenuControler {

    @Autowired
    MenuServiceImpl menuService;


    @PostMapping("add")
    public ResultJson add(Menu menu){
        menuService.save(menu);
        return ResultJson.returnOK(menu);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable Long id){
        return ResultJson.returnOK(menuService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(Menu menu){
        return ResultJson.returnOK( menuService.updateById(menu));
    }

    @GetMapping("list")
    public ResultJson list(){
        return ResultJson.returnOK(menuService.list());
    }
}
