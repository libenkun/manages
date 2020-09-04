package com.manages.background.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manages.background.pojo.Category;
import com.manages.background.utils.ResultJson;

/**
 * @author lbk
 * @date 2020/8/10 16:40
 **/
public interface CategoryService extends IService<Category> {

    ResultJson pages(Page<Category> page);
    ResultJson parentList();
}
