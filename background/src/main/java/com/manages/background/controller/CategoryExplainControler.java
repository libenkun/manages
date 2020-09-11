package com.manages.background.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.manages.background.pojo.CategoryExplain;
import com.manages.background.service.CategoryExplainService;
import com.manages.background.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lbk
 * @date 2020/9/8 15:37
 **/
@RestController
@RequestMapping("explain")
public class CategoryExplainControler {
    @Autowired
    CategoryExplainService categoryExplainService;

    @PostMapping("add")
    public ResultJson add(@RequestBody CategoryExplain categoryExplain){
        return ResultJson.returnOK(categoryExplainService.save(categoryExplain));
    }

    @PostMapping("saveCat")
    public ResultJson saveCat(CategoryExplain categoryExplain){
        return ResultJson.returnOK(categoryExplainService.save(categoryExplain));
    }


    @DeleteMapping("remover/{id}")
    public ResultJson remover(@PathVariable Long id) {
        return ResultJson.returnOK(categoryExplainService.removeById(id));
    }


    @PostMapping("update")
    public ResultJson update(@RequestBody CategoryExplain categoryExplain){
        return ResultJson.returnOK(categoryExplainService.updateById(categoryExplain));
    }

    @GetMapping("findExplain")
    public ResultJson findExplain(CategoryExplain categoryExplain){
        LambdaQueryWrapper<CategoryExplain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CategoryExplain::getCategoryId,categoryExplain.getCategoryId())
                    .eq(CategoryExplain::getTypes,categoryExplain.getTypes());
        return ResultJson.returnOK(categoryExplainService.list(queryWrapper));
    }

    @GetMapping("details/{id}")
    public ResultJson details(@PathVariable("id") Long id){
        return ResultJson.returnOK(categoryExplainService.getById(id));
    }
}

