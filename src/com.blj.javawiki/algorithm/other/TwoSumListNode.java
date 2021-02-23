package com.blj.javawiki.algorithm.other;


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

        System.out.println(Solution.toNumber(result));
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

            ListNode resultHead = null;
            ListNode resultTail = null;

            ListNode mHead = l1;
            ListNode nHead = l2;

            int upper = 0;

            int sum;
            int curValue;
            int countValue;
            while (null != mHead || null != nHead) {
                if (null == mHead) {
                    countValue = nHead.val;
                    nHead = nHead.next;
                } else if (null == nHead) {
                    countValue = mHead.val;
                    mHead = mHead.next;
                } else {
                    countValue = mHead.val + nHead.val;
                    mHead = mHead.next;
                    nHead = nHead.next;
                }

                sum = upper + countValue;

                curValue = sum % 10;

                if (sum >= 10) {
                    upper = sum / 10;
                } else {
                    upper = 0;
                }

                if (null == resultTail) {
                    resultTail = new ListNode(curValue);
                } else {
                    resultTail.next = new ListNode(curValue);
                }

                if (null == resultHead) {
                    resultHead = resultTail;
                }
            }
            return resultHead;
        }

//        static ListNode toListNode(long sum) {
//
//            if (0 == sum) {
//                return new ListNode(0);
//            }
//
//            ListNode head = null;
//            ListNode lastNode = null;
//            long toParseNum = sum;
//            while (toParseNum != 0) {
//
//                ListNode curNode = new ListNode((int) (toParseNum % 10));
//                if (null == head) {
//                    head = curNode;
//                }
//
//                if (null != lastNode) {
//                    lastNode.next = curNode;
//                }
//                toParseNum = toParseNum / 10;
//                lastNode = curNode;
//            }
//
//            return head;
//        }

        static String toNumber(ListNode listNode) {

            if (null == listNode) {
                return "" + 0;
            }
            StringBuffer stringBuffer = new StringBuffer();
            ListNode head = listNode;
            while (null != head) {
//                System.out.print(head.val);
                stringBuffer.append(head.val);
                head = head.next;
            }

            return stringBuffer.toString();

        }

//        ListNode reverse(ListNode head) {
//            if (head == null || head.next == null) {
//                //最终返回原来的尾结点
//                return head;
//            }
//            ListNode next = head.next;
//            head.next = null;
//            ListNode reversedNode = reverse(next);
//            next.next = head;
//            return reversedNode;
//        }
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
