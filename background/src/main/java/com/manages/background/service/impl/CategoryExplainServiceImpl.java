package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.CategoryExplainMapper;
import com.manages.background.pojo.CategoryExplain;
import com.manages.background.service.CategoryExplainService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/9/8 15:34
 **/
@Service
public class CategoryExplainServiceImpl extends ServiceImpl<CategoryExplainMapper,CategoryExplain> implements CategoryExplainService {
}
