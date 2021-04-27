package com.blj.javawiki.operator;

public class OperatorDemo {
    public static void main(String[] args) {
        System.out.println("16 >>> 1 =" + (16 >>> 1));
        System.out.println("((1 << 31)-1) =" + ((1 << 31) - 1));
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        System.out.println("(-(1 << 31)) =" + (-(1 << 31)));
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);

        int i = 10;
        System.out.println("i=" + i);
        System.out.println("~i=" + ~i);
    }
}
