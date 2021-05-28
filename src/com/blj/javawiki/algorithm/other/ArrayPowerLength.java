package com.blj.javawiki.algorithm.other;

import java.util.Arrays;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/5/27
 */
public class ArrayPowerLength {

//    输入是一个有序的数组，为数组中的每一个元素平方，把多余的重复元素去掉，输出剩余数组的大小
//
//  输入   [-1, 0, 0, 1, 2, 2]
//        [1, 0, 0, 1, 4, 4]
//        [1, 0, 4]
//        3

    public static void main(String[] args) {
        int[] arr = {-1, 0, 0, 1, 2, 2};
        System.out.println("length=" + getFinalArrayLengthBetter(arr));
    }

    public static int getFinalArrayLength(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return 0;
        }
        int[] powArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            powArray[i] = (int) Math.pow(arr[i], 2);
        }
        Arrays.sort(powArray);
        int count = 0;
        int last = -1;
        for (int i = 0; i < powArray.length; i++) {
            if (powArray[i] != last) {
                count++;
            }
            last = powArray[i];
        }
        return count;
    }

    public static int getFinalArrayLengthBetter(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int lastAbs = -1;
        int count = 0;
        while (left < right) {
            int leftAbs = Math.abs(arr[left]);
            int rightAbs = Math.abs(arr[right]);
            if (leftAbs > rightAbs) {
                if (leftAbs != lastAbs) {
                    count++;
                    lastAbs = leftAbs;
                }
                left++;
            } else {
                if (rightAbs != lastAbs) {
                    count++;
                    lastAbs = rightAbs;
                }
                right--;
            }
        }
        return count;
    }
}
