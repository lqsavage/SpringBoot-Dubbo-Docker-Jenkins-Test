package com.wy.user.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.wy.entity.user.UserEntity;
import com.wy.exception.CommonBizException;
import com.wy.exception.ExpCodeEnum;
import com.wy.facade.user.UserService;
import com.wy.req.user.LoginReq;
import com.wy.req.user.UserQueryReq;
import com.wy.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther：weib
 * @Date：2019/3/21 22 59
 * @Description:
 */
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserEntity login(LoginReq loginReq) {

        // 校验参数
       // checkParam(loginReq);

        // 创建用户查询请求
        UserQueryReq userQueryReq = buildUserQueryReq(loginReq);

        // 查询用户
        List<UserEntity> userEntityList = userDAO.findUsers(userQueryReq);

        // 查询失败
        if (CollectionUtils.isEmpty(userEntityList)) {
            throw new CommonBizException(ExpCodeEnum.LOGIN_FAIL);
        }

        // 查询成功
        return userEntityList.get(0);
    }

    /**
     * 构造用户查询对象
     * @param loginReq 登录请求
     * @return 用户查询请求
     */
    private UserQueryReq buildUserQueryReq(LoginReq loginReq) {
        UserQueryReq userQueryReq = new UserQueryReq();
        // 设置密码
        userQueryReq.setPassword(loginReq.getPassword());
        // 设置用户名
        if (StringUtils.isNotEmpty(loginReq.getUsername())) {
            userQueryReq.setUsername(loginReq.getUsername());
        }
        // 设置邮箱
        if (StringUtils.isNotEmpty(loginReq.getMail())) {
            userQueryReq.setMail(loginReq.getMail());
        }
        // 设置手机号
        if (StringUtils.isNotEmpty(loginReq.getPhone())) {
            userQueryReq.setPhone(loginReq.getPhone());
        }

        return userQueryReq;
    }
}
