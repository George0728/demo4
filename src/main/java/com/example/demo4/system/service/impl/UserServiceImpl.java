package com.example.demo4.system.service.impl;

import com.example.demo4.system.entity.User;
import com.example.demo4.system.mapper.UserMapper;
import com.example.demo4.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanson
 * @since 2023-02-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
