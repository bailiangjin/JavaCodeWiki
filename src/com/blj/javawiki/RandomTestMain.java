package com.blj.javawiki;

import java.util.Arrays;

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
