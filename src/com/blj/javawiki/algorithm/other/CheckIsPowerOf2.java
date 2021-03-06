package com.blj.javawiki.algorithm.other;

/**
 * 检测是否是2的n次方
 *
 * @author bailiangjin
 * @date 2021/4/3
 */
public class CheckIsPowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerOf2(1024));
    }

    public static boolean isPowerOf2(int number) {
        if (0 == number) {
            return true;
        }
        return 0 == (number & (number - 1));

    }
}
