package com.manages.background.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.background.dao.UserMapper;
import com.manages.background.pojo.User;
import com.manages.background.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lbk
 * @date 2020/7/31 14:11
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
