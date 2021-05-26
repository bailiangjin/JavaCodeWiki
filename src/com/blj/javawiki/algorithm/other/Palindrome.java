package com.blj.javawiki.algorithm.other;

public class Palindrome {

//    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
//    示例 1：
//
//    输入：x = 121
//    输出：true
//    示例2：
//
//    输入：x = -121
//    输出：false
//    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//    示例 3：
//
//    输入：x = 10
//    输出：false
//    解释：从右向左读, 为 01 。因此它不是一个回文数。
//    示例 4：
//
//    输入：x = -101
//    输出：false
//
//
//    提示：
//
//            -231<= x <= 231- 1
//
//
//    进阶：你能不将整数转为字符串来解决这个问题吗？

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(11311));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }

            String s = "" + x;
            char[] chars = s.toCharArray();
            int l = chars.length;
            for (int i = 0; i < (l + 1) / 2; i++) {
                if (chars[i] != chars[l - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public boolean isPalindrome(int x) {
            if (x < 0 || (0 == x % 10 && x != 0)) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            int reversNumber = 0;
            while (x > reversNumber) {
                reversNumber = reversNumber * 10 + x % 10;
                x /=  10;
            }
            return x == reversNumber || x == reversNumber / 10;
        }
    }
}
