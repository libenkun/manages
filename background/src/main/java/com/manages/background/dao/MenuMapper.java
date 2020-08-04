package com.manages.background.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manages.background.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author lbk
 * @date 2020/8/3 9:22
 **/
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> MenuListByPermission(@Param("ids") Set<Long> ids);
}
