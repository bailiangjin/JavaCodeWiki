package com.blj.javawiki.utils;

/**
 * 字符串相关工具类
 *
 * @author bailiangjin
 * @date 2019/3/18
 */
public class StringUtils {


    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
