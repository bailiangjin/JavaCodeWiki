package com.blj.javawiki.algorithm.other;

/**
 * 整数反转
 *
 * @author bailiangjin
 * @date 2021/2/25
 */
public class ReverseInt {

//    给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//
//    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//    假设环境不允许存储 64 位整数（有符号或无符号）。
//             
//
//    示例 1：
//
//    输入：x = 123
//    输出：321
//    示例 2：
//
//    输入：x = -123
//    输出：-321
//    示例 3：
//
//    输入：x = 120
//    输出：21
//    示例 4：
//
//    输入：x = 0
//    输出：0
//             
//
//    提示：
//
//            -231 <= x <= 231 - 1
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-integer
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new Solution2().reverse(2147483647));
    }

    static class Solution {
        public int reverse(int x) {

            long result = 0;
            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;
            }

            return (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ? 0 : (int) result;
        }
    }

    static class Solution2 {
        public int reverse(int x) {

            int result = 0;
            while (x != 0) {
                int temp = result * 10 + x % 10;
                if((temp - x%10)/10 != result){
                    return 0;
                }
                result = temp;
                x /= 10;

            }

            return result;
        }
    }
}
