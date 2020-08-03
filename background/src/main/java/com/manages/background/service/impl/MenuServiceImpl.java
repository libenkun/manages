package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.MenuMapper;
import com.manages.background.pojo.Menu;
import com.manages.background.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/8/3 9:31
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
