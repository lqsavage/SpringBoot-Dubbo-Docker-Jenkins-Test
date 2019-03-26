package com.wy.exception;

import java.io.Serializable;

/**
 * @Auther：weib
 * @Date：2019/3/26 09 39
 * @Description:通用系统异常
 */
public class CommonSysException  extends RuntimeException implements Serializable {
    private ExpCodeEnum codeEnum;

    public CommonSysException(ExpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonSysException() {

    }

}
