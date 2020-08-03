package com.manages.background.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manages.background.pojo.MenuPermission;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbk
 * @date 2020/8/3 16:26
 **/
@Repository
public interface MenuPermissionMapper extends BaseMapper<MenuPermission> {
}
