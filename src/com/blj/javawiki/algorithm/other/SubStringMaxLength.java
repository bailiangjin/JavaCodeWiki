package com.blj.javawiki.algorithm.other;

class SubStringMaxLength {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println("char =" + Integer.valueOf(' '));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int[] lastIndexArr = new int[128];
        for (int j = 0; j < lastIndexArr.length; j++) {
            lastIndexArr[j] = -1;
        }
        int start = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, lastIndexArr[s.charAt(i)] + 1);
            maxLength = Math.max(maxLength, i - start + 1);
            lastIndexArr[s.charAt(i)] = i;
        }
        return maxLength;
    }
}