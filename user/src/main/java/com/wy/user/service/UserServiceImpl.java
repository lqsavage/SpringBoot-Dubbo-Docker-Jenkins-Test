package com.wy.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wy.entity.user.UserEntity;
import com.wy.facade.user.UserService;
import com.wy.req.user.LoginReq;

/**
 * @Auther：weib
 * @Date：2019/3/21 22 59
 * @Description:
 */
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity login(LoginReq loginReq) {
        // 具体的实现代码
        UserEntity a = new UserEntity();
        return a;
    }
}
