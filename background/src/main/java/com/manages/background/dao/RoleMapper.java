package com.manages.background.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manages.background.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbk
 * @date 2020/8/3 9:24
 **/
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> roleListByUserId(@Param("userId") Long userId);
    List<Role> roleByUserId(@Param("userId") Long userId);
}
