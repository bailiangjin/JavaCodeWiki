package com.blj.javawiki;

import java.util.Arrays;
import java.util.Stack;

public class RandomTestMain {
    public static void main(String[] args) {

        int[] array = {3, 2, 1, 4, 6, 9, 7};
        insertSort(array);
        System.out.println("array = " + Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > -1 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}

class Solution {

    public String reverseParentheses(String s) {

        StringBuffer sb = new StringBuffer();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                stack.push(i);
            }

            if (arr[i] == ')') {
                reverse(arr, stack.pop() + 1, i - 1);
            }
        }

        for (char c : arr) {
            if (c != ')' && c != '(') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public void reverse(char[] arr, int left, int right) {

        while (right > left) {

            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            right--;
            left++;
        }
    }
//    public String reverseParentheses2(String s) {
//
//        Stack<Object> stack = new Stack<>();
//        StringBuffer stringBuffer = new StringBuffer();
//        int startCount = 0;
//        int endCount = 0;
//
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (stack.isEmpty()) {
//                stringBuffer.append(c);
//            } else if (')' == c && endCount == startCount - 1) {
//                // TODO: 2021/5/26 pop all
//                while (!stack.isEmpty()){
//                    Object character = stack.pop();
//                    if('(' == character){
//                        startCount--;
//                    }else if(')' == character){
//                        endCount--;
//                    }else {
//                        if ()
//
//                    }
//                    character
//                }
//            } else {
//                if ('(' == c) {
//                    startCount++;
//                }
//                if (')' == c) {
//                    endCount++;
//                }
//                stack.push(c);
//            }
//        }
//
//    }
}
