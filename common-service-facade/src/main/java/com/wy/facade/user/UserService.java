package com.wy.facade.user;

import com.wy.entity.user.UserEntity;
import com.wy.req.user.LoginReq;

/**
 * @Auther：weib
 * @Date：2019/3/21 22 26
 * @Description:
 */
public interface UserService {
    public UserEntity login(LoginReq loginReq);
}
