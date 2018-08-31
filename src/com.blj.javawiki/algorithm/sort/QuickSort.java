package com.blj.javawiki.algorithm.sort;

import com.blj.javawiki.algorithm.sort.interfaze.ISort;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class QuickSort {

    /**
     * 快速排序接口 Array
     */
    public interface IQuickSortArray extends ISort<Integer[]> {


    }

    /**
     * 快速排序接口 List
     */
    public interface IQuickSortList extends ISort<List<Integer>> {


    }


    /**
     * 快速排序 数据结构与算法分析-java版 实现
     */
    public static class QuickSort1 implements IQuickSortList {

        @Override
        public void sort(List<Integer> items) {
            if (items.size() <= 1) {
                return;
            }

            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer item : items) {
                if (item < chosenItem) {
                    smaller.add(item);
                } else if (item > chosenItem) {
                    larger.add(item);
                } else {
                    same.add(item);
                }
            }
            sort(smaller);
            sort(larger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }


    /**
     * 快速排序 数据结构与算法分析-java版 实现
     */
    public static class QuickSort2 implements IQuickSortArray {
        @Override
        public void sort(Integer[] array) {
            quickSort(array, 0, array.length - 1);

        }

        /**
         * 快速排序
         *
         * @param array
         * @param low
         * @param high
         */
        public void quickSort(Integer[] array, int low, int high) {
            if (low >= high) {
                //数据源少于两个数，就返回
                return;
            }
            //用于确定基准位的下标
            int pivot = low;
            //从左至右遍历，找出所有比基准值小的数
            for (int i = low; i < high; i++) {
                //以最右边的数为基准值
                if (array[i] > array[high]) {
                    swap(array, pivot++, i);
                }
            }
            //让基准数归位
            swap(array, pivot, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);

        }

        public static void swap(Integer[] array, int left, int right) {
            if (left == right) {
                return;
            }
            System.out.println(String.format("SWAP==> array[left%d]=%d array[right%d]=%d", left, array[left], right, array[right]));
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

    }


}
