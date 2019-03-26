package com.wy.untils;

import java.util.UUID;

/**
 * @Auther：weib
 * @Date：2019/3/26 09 49
 * @Description:主键生成器
 */
public class KeyGenerator {
    /**
     * 获得一个UUID
     * @return String UUID
     */
    public static String getKey(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
