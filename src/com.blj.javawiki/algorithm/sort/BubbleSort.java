package com.blj.javawiki.algorithm.sort;

import com.blj.javawiki.algorithm.sort.interfaze.ISort;

/**
 * 冒泡排序
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class BubbleSort implements ISort<Integer[]> {

    @Override
    public void sort(Integer[] array) {
        if (null == array || array.length <= 1) {
            return;
        }
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}