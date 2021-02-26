package com.blj.javawiki.algorithm.other;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {


//    给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。
//
//
//
//    示例 1：
//
//    输入：nums = [-1,0,1,2,-1,-4]
//    输出：[[-1,-1,2],[-1,0,1]]
//    示例 2：
//
//    输入：nums = []
//    输出：[]
//    示例 3：
//
//    输入：nums = [0]
//    输出：[]
//
//
//    提示：
//
//            0 <= nums.length <= 3000
//            -105 <= nums[i] <= 105

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            if (nums.length < 3) {
                return resultList;
            }
            HashMap<String, List<Integer>> resultMap = new HashMap<>();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (0 == nums[i] + nums[j] + nums[k]) {
                            int[] itemArray = new int[]{nums[i], nums[j], nums[k]};
                            Arrays.sort(itemArray);
                            String key = Arrays.toString(itemArray);
                            if (!resultMap.containsKey(key)) {
                                ArrayList<Integer> item = new ArrayList<>();
                                item.add(nums[i]);
                                item.add(nums[j]);
                                item.add(nums[k]);
                                resultMap.put(key, item);
                            }
                        }
                    }
                }
            }

            if (!resultMap.isEmpty()) {
                resultList.addAll(resultMap.values());
            }
            return resultList;
        }
    }

    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            if (nums.length < 3) {
                return resultList;
            }
            Arrays.sort(nums);

            HashMap<String, int[]> resultMap = new HashMap<>();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (0 == nums[i] + nums[j] + nums[k]) {
                            int[] itemArray = new int[]{nums[i], nums[j], nums[k]};
                            Arrays.sort(itemArray);
                            String key = Arrays.toString(itemArray);
                            if (!resultMap.containsKey(key)) {
                                resultMap.put(key, itemArray);
                            }
                        }
                    }
                }
            }

            if (!resultMap.isEmpty()) {
                for (int[] item : resultMap.values()) {
                    List<Integer> itemList = Arrays.stream(item).boxed().collect(Collectors.toList());
                    resultList.add(itemList);
                }
            }
            return resultList;
        }
    }
}
