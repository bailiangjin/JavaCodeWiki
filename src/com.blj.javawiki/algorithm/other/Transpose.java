package com.blj.javawiki.algorithm.other;

import java.util.Arrays;

/**
 * 转置矩阵
 *
 * @author bailiangjin
 * @date 2021/2/25
 */
public class Transpose {

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
//                        {1, 2, 3, 4},
//                        {5, 6, 7, 8},
//                        {9, 10, 11, 12},
//                        {13, 114, 15, 16}

                        {1, 2, 3},
                        {4, 5, 6}
                };

        printArray(matrix);
        printArray(new Solution().transpose(matrix));
    }

    public static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    static class Solution {
        public int[][] transpose(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;

//            if (m == n) {
//                int temp;
//                for (int i = 0; i < m; i++) {
//
//                    for (int j = i + 1; j < n; j++) {
//                        //System.out.println("i=" + i + " j=" + j);
//                        temp = matrix[i][j];
//                        matrix[i][j] = matrix[j][i];
//                        matrix[j][i] = temp;
//                    }
//
//                }
//                return matrix;
//            } else {
                int[][] trans = new int[n][m];

                for (int i = 0; i < m; i++) {

                    for (int j = 0; j < n; j++) {
                        trans[j][i] = matrix[i][j];
                    }
                }
                return trans;
//            }
        }
    }
}
