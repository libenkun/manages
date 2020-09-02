package com.manages.background.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.CategoryMapper;
import com.manages.background.pojo.Category;
import com.manages.background.service.CategoryService;
import com.manages.background.utils.ResultJson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author lbk
 * @date 2020/8/10 16:43
 **/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public ResultJson pages(Page<Category> page) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getPid,0);
        IPage<Category> list = (this.page(page,queryWrapper));
        if (!list.getRecords().isEmpty()){
            list.getRecords().stream().forEach(item->{
                if (Objects.nonNull(item)){
                    item.setList(this.seeCategory(item.getId()));
                }
            });
        }
        return ResultJson.returnOK(list);
    }

    private List<Category> seeCategory(Long id){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getPid,id);
        List<Category> list = this.list(queryWrapper);
        list.stream().forEach(item->{
            if (Objects.nonNull(item)){
                item.setList(this.categoryList(item.getId()));
            }
        });
        return list;
    }

    private List<Category> categoryList(Long id){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getPid,id);
        List<Category> list = this.list(queryWrapper);
        list.stream().forEach(item->{
            if (Objects.nonNull(item)){
                item.setList(this.seeCategory(item.getId()));
            }
        });

        return list;
    }
}
