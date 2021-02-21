package com.blj.javawiki.algorithm.other;

/**
 * 寻找数组中位数
 *
 * @author bailiangjin
 * @date 2021/2/21
 */
public class FindArrayMiddleNumber {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

      System.out.println( new Solution().findMedianSortedArrays(nums1,nums2));
    }

   static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int length1 = nums1.length;
            int length2 = nums2.length;

            int[] allNums = new int[length1 + length2];

            int totalLength = allNums.length;

            int index1 = 0;
            int index2 = 0;


            for (int i = 0; i < totalLength; i++) {
                boolean isArray1Empty = index1 >= length1;
                boolean isArray2Empty = index2 >= length2;
                if (!isArray1Empty && !isArray2Empty) {
                    if (nums1[index1] < nums2[index2]) {
                        allNums[i] = nums1[index1];
                        index1++;
                    } else {
                        allNums[i] = nums2[index2];
                        index2++;
                    }
                } else if (!isArray1Empty) {
                    allNums[i] = nums1[index1];
                    index1++;
                } else if (!isArray2Empty) {
                    allNums[i] = nums2[index2];
                    index2++;
                }
            }

            if (totalLength % 2 == 1) {
                return allNums[totalLength / 2];
            } else {
                double count = (allNums[totalLength / 2-1] + allNums[totalLength / 2]);
                return count / 2;
            }
        }
    }
}
