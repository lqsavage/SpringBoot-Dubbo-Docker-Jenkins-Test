package com.wy.untils;

import com.wy.enumeration.BaseEnum;

/**
 * @Auther：weib
 * @Date：2019/3/26 09 47
 * @Description:
 */
public class EnumUtil {

    /**
     * 根据code获取枚举
     * @param enumClass
     * @param code
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据msg获取枚举
     * @param enumClass
     * @param msg
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & BaseEnum> E msgOf(Class<E> enumClass, String msg) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getMsg().equals(msg)) {
                return e;
            }
        }
        return null;
    }


}
