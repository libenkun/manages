package com.manages.background.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manages.background.pojo.Role;
import com.manages.background.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbk
 * @date 2020/7/31 14:10
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {

}
