package com.wy.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wy.entity.user.UserEntity;
import com.wy.facade.user.UserService;
import com.wy.req.user.LoginReq;
import com.wy.rsp.Result;
import com.wy.untils.KeyGenerator;
import com.wy.untils.RedisPrefixUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther：weib
 * @Date：2019/3/26 16 03
 * @Description:
 */
@RestController
public class UserControllerImpl implements UserController{
    @Reference(version = "1.0.0")
    private UserService userService;

    @Override
    public Result login(LoginReq loginReq, HttpServletResponse httpRsp) {

        // 登录鉴权
        UserEntity userEntity = userService.login(loginReq);

        // 登录成功
        doLoginSuccess(userEntity, httpRsp);

        return Result.newSuccessResult();
    }
    /**
     * 处理登录成功
     * @param userEntity 用户信息
     * @param httpRsp HTTP响应参数
     */
    private void doLoginSuccess(UserEntity userEntity, HttpServletResponse httpRsp) {
        // 生成SessionID
        String sessionID = RedisPrefixUtil.SessionID_Prefix + KeyGenerator.getKey();

        // 将 SessionID-UserEntity 存入Redis
        // TODO 暂时存储本地
//        redisService.set(sessionID, userEntity, sessionExpireTime);
        //RedisServiceTemp.userMap.put(sessionID, userEntity);

        // 将SessionID存入HTTP响应头
       // Cookie cookie = new Cookie(sessionIdName, sessionID);
      //  httpRsp.addCookie(cookie);
    }


}
