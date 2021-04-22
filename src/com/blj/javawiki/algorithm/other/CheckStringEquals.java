package com.blj.javawiki.algorithm.other;

import java.util.Arrays;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/4/21
 */
public class CheckStringEquals {

    public static void main(String[] args) {
        System.out.println("isEquals="+ isEquals("abcd","abdc"));
    }


    public static boolean isEquals(String s1, String s2) {

        boolean isS1Empty = null == s1 || 0 == s1.length();
        boolean isS2Empty = null == s2 || 0 == s2.length();
        if (isS1Empty && !isS2Empty || !isS1Empty && isS2Empty) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (char c : c1) {
            array1[c - 'a']++;
        }

        for (char c : c2) {
            array2[c - 'a']++;
        }
        return Arrays.equals(array1, array2);
    }
}
