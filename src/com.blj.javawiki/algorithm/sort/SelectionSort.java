package com.blj.javawiki.algorithm.sort;

import com.blj.javawiki.algorithm.sort.interfaze.ISort;

/**
 * 选择排序 从前往后 逐个找到最小的元素记录其下标 最终将其移动到已排序队列的末尾
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class SelectionSort implements ISort<Integer[]> {
    @Override
    public void sort(Integer[] array) {

        int n = array.length;
        int minIndex;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            //未排序序列中最小数据数组下标
            minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    //在未排序元素中继续寻找最小元素，并保存其下标
                    minIndex = j;
                }
            }

            //将最小元素放到已排序序列的末尾
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
