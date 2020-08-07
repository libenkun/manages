package com.manages.background.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.MenuMapper;
import com.manages.background.pojo.Menu;
import com.manages.background.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author lbk
 * @date 2020/8/3 9:31
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> menuList(Set<Long> set) {
        List <Menu> menuList = menuMapper.MenuListByPermission(set);
        if (!menuList.isEmpty()){
            menuList.stream().forEach(item->{
                List<Menu> childMenu = this.menus(item.getId());
                if (!childMenu.isEmpty()){
                    item.setMenusChild(childMenu);
                }
            });
        }
        return menuList;
    }

    @Override
    public List<Menu> menus(Long pid) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getPid,pid);
        List<Menu> list = this.list(queryWrapper);
        return list;
    }
}
