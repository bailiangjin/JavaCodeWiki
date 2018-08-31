package com.blj.javawiki.algorithm.sort;


/**
 * 排序
 *
 * @author bailiangjin
 * @date 2018/8/30
 */
public class SortMaiin {

    public static void main(String[] args) {
        Integer[] array = {1, 9, 8, 3, 5, 2, 3, 7, 4};
        //quickSort(array, 0, array.length - 1);
        //bubbleSort(array);
        //insertionSort(array);
        //quickSort(array, 0, array.length - 1);
//        quickSort1(array, 0, array.length - 1);
//        List<Integer> items = new ArrayList<>();
//        for (int item : array) {
//            items.add(item);
//        }
//        new QuickSort.QuickSort1().sort(items);
//        System.out.print(items);

        //new MergeSort().sort(array);
        new SelectionSort().sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }

    }













}