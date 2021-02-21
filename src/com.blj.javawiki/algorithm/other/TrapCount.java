package com.blj.javawiki.algorithm.other;

import java.util.Stack;

/**
 * 接雨水
 *
 * @author bailiangjin
 * @date 2021/2/21
 */
public class TrapCount {


    /**
     * 接雨水
     */
    class Solution {

        public int trap(int[] height) {

            int trap = 0;

            int leftTopHeight = 0;

            Stack<Integer> heightStack = new Stack();


            for (int i = 0; i < height.length; i++) {
                int curHeight = height[i];


                if (curHeight > leftTopHeight) {
                    // 新的高度记录 之前的深度可确定，赋值出栈
                    int countTopHeight = leftTopHeight;
                    if (!heightStack.empty()) {
                        //出栈 累加已确定水量
                        while (!heightStack.empty()) {
                            int curCountHeight = heightStack.pop();
                            int curTrap = countTopHeight - curCountHeight;
                            trap += curTrap;
                        }
                    }
                    leftTopHeight = curHeight;
                }

                heightStack.push(curHeight);

                if (i == height.length - 1) {
                    //已遍历完所有item 从右侧向左依次计算输出
                    if (!heightStack.isEmpty()) {
                        int rightTopHeight = 0;
                        while (!heightStack.empty()) {
                            int curCountHeight = heightStack.pop();
                            if (curCountHeight < rightTopHeight) {
                                int curTrap = rightTopHeight - curCountHeight;
                                trap += curTrap;
                            } else {
                                rightTopHeight = curCountHeight;
                            }
                        }
                    }
                }
            }

            return trap;

        }
    }

    /**
     * 接雨水
     */
    class Solution2 {

        public int trap(int[] height) {

            int left = 0;
            int right = height.length - 1;

            int leftTop = 0;
            int rightTop = 0;


            int rain = 0;

            while (left < right) {

                leftTop = Math.max(leftTop,height[left]);
                rightTop = Math.max(rightTop,height[right]);

                if (leftTop > rightTop) {
                    rain += rightTop - height[right];
                    right--;

                } else {
                    rain += leftTop - height[left];
                    left++;
                }
            }

            return rain;
        }
    }
}
