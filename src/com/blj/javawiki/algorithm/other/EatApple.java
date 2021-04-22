package com.blj.javawiki.algorithm.other;

/**
 * 吃苹果
 *
 * @author bailiangjin
 * @date 2021/4/19
 */
public class EatApple {

    public static void main(String[] args) {
        System.out.print(countEatPlan(36));
    }

//    x 个苹果，一天只能吃一个、两个、或者三个，问多少天可以吃完

//    6个苹果,每天至少吃一个,吃完为止，一共有多少种？ 答案是：32种，但是我看不懂！

//    六个一样的苹果，排成一排，之间有5个空。想像按吃的天数用隔板把它们分成每天不同的数量。
//            6天，相当用5个插板插入5个空中，苹果分成了6份：C（5，5）=1
//            5天，相当用4个插板插5个空，苹果分成了5份：C（5，4）=5
//            （这也不难理解：有一天是2个苹果，可以第1、2、3、4、5中的某一天吃）
//            4天，C（5，3）=10
//            3天，C（5，2）=10
//            2天，C（5，1）=5
//            1天，C（5，0）=1
//    总的方法为：1+5+10+10+5+1=32种

    public static int countEatPlan(int appleLeft) {
        if (appleLeft < 1) {
            return 0;
        }

        if (appleLeft == 1) {
            return 1;
        }

        if (appleLeft == 2) {
            return 2;
        }

        if (appleLeft == 3) {
            return 4;
        }
        return countEatPlan(appleLeft - 1)
                + countEatPlan(appleLeft - 2)
                + countEatPlan(appleLeft - 3);
    }
}
