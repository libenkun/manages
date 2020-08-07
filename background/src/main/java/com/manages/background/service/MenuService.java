package com.manages.background.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manages.background.pojo.Menu;

import java.util.List;
import java.util.Set;

/**
 * @author lbk
 * @date 2020/8/3 9:27
 **/
public interface MenuService extends IService<Menu> {
    List<Menu> menuList(Set<Long> set);
    List<Menu> menus(Long pid);
}
