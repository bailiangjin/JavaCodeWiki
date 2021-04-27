package com.blj.javawiki.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个整数之和
 *
 * @author bailiangjin
 * @date 2021/2/21
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int curIndex = 0;

            while (curIndex < nums.length - 1) {
                for (int i = curIndex + 1; i < nums.length; i++) {
                    if (nums[curIndex] + nums[i] == target) {
                        int[] indexArray = {curIndex, i};
                        return indexArray;
                    }
                }
                curIndex++;
            }
            return null;
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> numMap = new HashMap<>();
            int index = 0;
            for (int item :nums) {
              if(numMap.containsKey(target -item)) {
                  int[] indexArray = {index,  numMap.get(target -item)};
                  return indexArray;
              }

                numMap.put(item,index);
                index ++;
            }
            return  null;
        }
    }
}
