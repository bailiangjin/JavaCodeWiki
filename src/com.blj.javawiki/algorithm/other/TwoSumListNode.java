package com.blj.javawiki.algorithm.other;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/2/21
 */
public class TwoSumListNode {


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
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int num1;
            int num2;
            int sum;

            num1 = toNumber(l1, 0, 0);
            num2 = toNumber(l2, 0, 0);
            sum = num1 + num2;

            return toListNode(sum);

        }

        ListNode toListNode(int sum) {

            if (0 == sum) {
                return new ListNode(sum);
            }

            ListNode head = null;
            ListNode lastNode = null;
            int toParseNum = sum;
            while (toParseNum != 0) {

                ListNode curNode = new ListNode(toParseNum % 10);
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

        int toNumber(ListNode listNode, int number, int power) {

            if (null == listNode) {
                return number;
            }

            number = number + listNode.val * (int) Math.pow(10, power);

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


    public class ListNode {
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
