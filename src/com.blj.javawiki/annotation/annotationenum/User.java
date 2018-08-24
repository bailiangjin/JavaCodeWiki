package com.blj.javawiki.annotation.annotationenum;

/**
 * 用户类
 *
 * @author bailiangjin
 * @date 2018/8/24
 */
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别
     */
    @GenderType.Type
    private int gender;
    /**
     * 年龄
     */
    private int age;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String phoneNumber;

    public User() {
    }
}