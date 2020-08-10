package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.CategoryMapper;
import com.manages.background.pojo.Category;
import com.manages.background.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/8/10 16:43
 **/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
