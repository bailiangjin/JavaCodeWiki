package com.blj.javawiki.algorithm.search;

/**
 * 查找实现类
 *
 * @author bailiangjin
 * @date 2018/9/25
 */
public class SearchImpl implements ISearch {

    /**
     * 二维数组 查找
     *
     * 二维数组matrix中，每一行都从左到右递增排序，每一列都从上到下递增排序
     *
     * @param matrix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    @Override
    public  boolean find(int[][] matrix, int rows, int columns, int number) {

        if (matrix != null && rows > 0 && columns > 0) {
            // 当前行 从第一行开始
            int curRow = 0;
            // 当前列 从最后一列开始
            int curColumn = columns - 1;
            // 行：从上到下，列：从右到左
            while (curRow < rows && curColumn >= 0) {
                if (matrix[curRow][curColumn] == number) {
                    return true;
                } else if (matrix[curRow][curColumn] > number) {
                    curColumn--;
                } else {
                    curRow++;
                }
            }
        }
        return false;
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int i=0;
            int j=nums.length-1;
            while(i<j){
                if(0==nums[i]){
                    swap(nums,i,j);
                    j--;
                }
                i++;
            }
        }

        private void swap(int[] nums,int i,int j){
            int temp =nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
