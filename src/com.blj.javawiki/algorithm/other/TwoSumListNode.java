package com.blj.javawiki.algorithm.other;

import java.math.BigDecimal;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/2/21
 */
public class TwoSumListNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2
                = new ListNode(1,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9,
                                                                        new ListNode(9,
                                                                                new ListNode(9
                                                                                ))))))))));
        ListNode result = new Solution().addTwoNumbers(l1, l2);

        System.out.println(Solution.toNumber(result, 0, 0));
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode resutHead = null;
            ListNode resutTail = null;

            ListNode mHead = l1;
            ListNode nHead =l2;

            int uper = 0;


            boolean mEnd= null ==l1;
            boolean nEnd = null ==l2;

            while (!mEnd ||!mEnd){
                if(mEnd){
                    resutTail.next = new ListNode(nHead.val);
                    nHead = nHead.next;
                    continue;
                }

                if(nEnd){
                    resutTail.next = new ListNode(mHead.val);
                    nHead = mHead.next;
                    continue;
                }



                 int sum = uper+   mHead.val +nHead.val;


            }


            BigDecimal num1;
            BigDecimal num2;
            BigDecimal sum;

            num1 = toNumber(l1, 0, 0);
            num2 = toNumber(l2, 0, 0);
            System.out.println("num1=" + num1);
            System.out.println("num2=" + num2);
            sum = num1 + num2;

            return toListNode(sum);

        }

        static ListNode toListNode(long sum) {

            if (0 == sum) {
                return new ListNode(0);
            }

            ListNode head = null;
            ListNode lastNode = null;
            long toParseNum = sum;
            while (toParseNum != 0) {

                ListNode curNode = new ListNode((int) (toParseNum % 10));
                if (null == head) {
                    head = curNode;
                }

                if (null != lastNode) {
                    lastNode.next = curNode;
                }
                toParseNum = toParseNum / 10;
                lastNode = curNode;
            }

            return head;
        }

        static BigDecimal toNumber(ListNode listNode, BigDecimal number, int power) {

            if (null == listNode) {
                return number;
            }

            BigDecimal plusValue = listNode.val * BigDecimal.valueOf(Math.pow(10, power)) ;
            System.out.println("plusValue=" + plusValue);
            number +=plusValue;

            return toNumber(listNode.next, number, power + 1);

        }

        ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                //最终返回原来的尾结点
                return head;
            }
            ListNode next = head.next;
            head.next = null;
            ListNode reversedNode = reverse(next);
            next.next = head;
            return reversedNode;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
