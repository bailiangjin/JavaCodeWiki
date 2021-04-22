package com.blj.javawiki.algorithm.other;

/**
 * 一百步
 *
 * @author bailiangjin
 * @date 2019/2/28
 */
public class OneHundredStep {

    public static void main(String[] args) {
        System.out.print(countSteps(100));
    }

    public static int countSteps(int stepLeft) {
        if (stepLeft < 1) {
            return 0;
        }

        if (stepLeft == 1) {
            return 1;
        }

        if (stepLeft == 2) {
            return 2;
        }

        return countSteps(stepLeft - 1) + countSteps(stepLeft - 2);
    }
}
