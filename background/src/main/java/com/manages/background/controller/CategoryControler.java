package com.manages.background.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manages.background.pojo.Category;
import com.manages.background.service.impl.CategoryServiceImpl;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author lbk
 * @date 2020/8/10 16:44
 **/
@RestController
@RequestMapping("category")
public class CategoryControler {

    @Autowired
    CategoryServiceImpl categoryService;


    @PostMapping("add")
    public ResultJson add(@RequestBody Category category){
        categoryService.save(category);
        return ResultJson.returnOK(category);
    }

    @DeleteMapping("/{id}")
    public ResultJson remover(@PathVariable("id") Long id){
        return ResultJson.returnOK(categoryService.removeById(id));
    }

    @PostMapping("update")
    public ResultJson update(Category category){
        return ResultJson.returnOK(categoryService.updateById(category));
    }

    @GetMapping("list")
    public ResultJson list(){
//        return ResultJson.returnOK(categoryService.list());
          return categoryService.parentList();
    }

    @GetMapping("page")
    public ResultJson page(Page<Category> page){
        return categoryService.pages(page);
    }

    @GetMapping("lists")
    public ResultJson lists(Category category){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getPid,0);
        if (Objects.nonNull(category.getName())){
            queryWrapper.like(Category::getName,category.getName());
        }
        return ResultJson.returnOK(categoryService.list(queryWrapper));
    }

    @GetMapping("categoryList")
    public ResultJson categoryList(){
        return categoryService.categoryList();
    }

}
