package com.blj.javawiki.algorithm.sort;

import com.blj.javawiki.algorithm.sort.interfaze.ISort;

/**
 * 插入排序
 *
 * @author bailiangjin
 *
 * @date 2018/8/31
 */
public class InsertSort implements ISort<Integer[]> {

    @Override
    public void sort(Integer[] array) {
        if (null == array || array.length <= 1) {
            return;
        }   if (null == array || array.length <= 1) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > -1 && (array[j] > key)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}