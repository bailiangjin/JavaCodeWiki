package com.blj.javawiki.algorithm.other;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author bailiangjin
 * @date 2021/3/1
 */
public class SearchRange {


    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int[] result = new int[]{-1, -1};

            if (null == nums || 0 == nums.length) {
                return result;
            }

            if (nums[0] > target || nums[nums.length - 1] < target) {
                return result;
            }

            int l = 0;
            int h = nums.length - 1;

//            int m = (l + h) / 2;
            while (l < h) {
                int m = (l + h) / 2;
                if (nums[m] > target) {
                    h = m;
                } else if (nums[m] < target) {
                    l = m;
                } else {

                }


            }


            if ()


                return null;

        }
    }
}
