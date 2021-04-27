package com.blj.javawiki.algorithm.search;

/**
 * 查找接口
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public interface ISearch {

    /**
     * 二维有序数组查找
     *
     * 二维数组matrix中，每一行都从左到右递增排序，每一列都从上到下递增排序
     *
     * @param matrix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    boolean find(int[][] matrix, int rows, int columns, int number);

}
