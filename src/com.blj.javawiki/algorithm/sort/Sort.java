package com.blj.javawiki.algorithm.sort;

/**
 * 排序
 *
 * @author bailiangjin
 * @date 2018/8/30
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = {1, 9, 8, 3, 5, 2, 3, 7, 4};
        //quickSort(array, 0, array.length - 1);
        //bubbleSort(array);
        //insertionSort(array);
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + "\t");
        }

    }


    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {

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

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
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


//    /**
//     * 快速排序
//     *
//     * @param arr  数组
//     * @param low  低位
//     * @param high 高位
//     */
//    public static void quickSort(int arr[], int low, int high) {
//        int l = low;
//        int h = high;
//        /**
//         * 中间数
//         */
//        int pivot = arr[low];
//
//        while (l < h) {
//            while (l < h && arr[h] >= pivot) {
//                h--;
//            }
//            if (l < h) {
//                swap(arr, l, h);
//                l++;
//            }
//
//            while (l < h && arr[l] <= pivot) {
//                l++;
//            }
//            if (l < h) {
//                swap(arr, l, h);
//                h--;
//            }
//        }
//        for (int i : arr) {
//            System.out.print(i + "\t");
//        }
//        System.out.print("l=" + (l) + "h=" + (h) + "povit=" + pivot + "\n");
//        if (l > low) {
//            quickSort(arr, low, l - 1);
//        }
//        if (h < high) {
//            quickSort(arr, l + 1, high);
//        }
//    }

//    public static void swap(int[] array, int left, int right) {
//        int temp = array[left];
//        array[left] = array[right];
//        array[right] = temp;
//    }


    public static void quickSort(int[] n) {
        if (0 == n.length) {
            return;
        }
        quickSort(n, 0, n.length - 1);
    }

    public static void quickSort(int[] array, int l, int h) {
        if (0 == array.length) {
            return;
        }
        if (l < h) {
            int pivot = portion(array, l, h);
            quickSort(array, l, pivot - 1);
            quickSort(array, pivot + 1, h);
        }
    }

    private static int portion(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (array[end] >= temp && start < end) {
                end--;
            }
            if (start < end) {
                array[start++] = array[end];
            }
            while (array[start] < temp && start < end) {
                start++;
            }
            if (start < end) {
                array[end--] = array[start];
            }
        }
        array[start] = temp;
        return start;

    }
}