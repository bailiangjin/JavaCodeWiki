package com.blj.javawiki.algorithm.sort;


import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/**
 * 排序
 *
 * @author bailiangjin
 * @date 2018/8/30
 */
public class SortMaiin {

    public static void main(String[] args) {
        Integer[] array = {1, 9, 8, 3, 5, 2, 3, 7, 4};
        Integer[] array2 = {1,2};

//        List<Integer> items = new ArrayList<>();
//        for (int item : array) {
//            items.add(item);
//        }
//        new QuickSort.QuickSort1().sort(items);
//        System.out.print(items);

        //new MergeSort().sort(array);
        //new InsertSort().sort(array);
        //new BubbleSort().sort(array);
        //new SelectionSort().sort(array);

//        for (int i : array) {
//            System.out.print(i + "\t");
//        }

//        int[] nums= {2,0,2,1,1,0};
        Integer[] nums= {1,2,3};
        new QuickSort.QuickSort2().sort(nums);

        for (int num: nums) {
            System.out.println(num);
        }

    }













}