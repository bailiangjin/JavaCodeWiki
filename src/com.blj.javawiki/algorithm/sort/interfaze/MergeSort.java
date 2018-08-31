package com.blj.javawiki.algorithm.sort.interfaze;

/**
 * 归并排序
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class MergeSort implements ISort<Integer[]> {
    @Override
    public void sort(Integer[] array) {
        mergeSort(array);

    }

    /**
     * Mergesort algorithm.
     *
     * @param array an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] array) {

        AnyType[] tmpArray = (AnyType[]) new Comparable[array.length];

        mergeSort(array, tmpArray, 0, array.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param array    an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left     the left-most index of the subarray.
     * @param right    the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] array, AnyType[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tmpArray, left, center);
            mergeSort(array, tmpArray, center + 1, right);
            merge(array, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param array    an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos  the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] array, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tmpArray[tmpPos++] = array[leftPos++];
            } else {
                tmpArray[tmpPos++] = array[rightPos++];
            }
        }

        while (leftPos <= leftEnd)    // Copy rest of first half
        {
            tmpArray[tmpPos++] = array[leftPos++];
        }

        while (rightPos <= rightEnd)  // Copy rest of right half
        {
            tmpArray[tmpPos++] = array[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }
    }
}
