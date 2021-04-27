package com.blj.javawiki.demo;

/**
 * Created by bailiangjin on 2017/7/15.
 */
public class TryCatchFinallyTest {

    /**
     * @paramargs add by zxx ,Dec 9, 2008
     */
    public static void main(String[] args) {

        System.out.println(test());
    }

    static int test() {
        int x = 1;
        try {
            return x;

        } catch (Exception e) {
            return 0;
        } finally {
            ++x;
            return x;
        }
    }
}
