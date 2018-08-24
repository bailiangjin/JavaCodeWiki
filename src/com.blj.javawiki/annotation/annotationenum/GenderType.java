package com.blj.javawiki.annotation.annotationenum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解 使用int 实现枚举类型实例
 * 性别
 *
 * @author bailiangjin
 * @date 2018/7/9
 */
public interface GenderType {

    /**
     * 未知
     */
    int UN_KNOWN = 0;

    /**
     * 男性
     */
    int MALE = 1;
    /**
     * 女性
     */
    int FEMALE = 2;


    // 自定义一个注解 Type
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            UN_KNOWN,
            MALE,
            FEMALE
    })
    @interface Type {
    }

}