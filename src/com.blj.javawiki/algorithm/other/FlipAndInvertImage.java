package com.blj.javawiki.algorithm.other;

public class FlipAndInvertImage {

//    给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//
//    水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//
//    反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//
//             
//
//    示例 1：
//
//    输入：[[1,1,0],[1,0,1],[0,0,0]]
//    输出：[[1,0,0],[0,1,0],[1,1,1]]
//    解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//    然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
//    示例 2：
//
//    输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//    输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//    解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//    然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//             
//
//    提示：
//
//            1 <= A.length = A[0].length <= 20
//            0 <= A[i][j] <= 1
//    通过次数66,463提交次数83,842
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/flipping-an-image
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);

    }

    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {

            for (int[] row : A) {

                int length = row.length;
                for (int j = 0; j < (length + 1) / 2; j++) {
                    int temp = 1 ^ row[j];
                    row[j] = 1 ^ row[length - 1 - j];
                    row[length - 1 - j] = temp;
                }
            }

            return A;
        }
    }
}
