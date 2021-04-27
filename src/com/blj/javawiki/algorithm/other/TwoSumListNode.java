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

            ListNode result = null;
            ListNode current = null;

            int upper = 0;

            while (null != l1 || null != l2 || upper != 0) {

                int l1Value = null ==l1? 0: l1.val;
                int l2Value = null ==l2? 0: l2.val;

                int sum = upper +l1Value +l2Value;

                upper = sum / 10;


                if (null == current) {
                    current = new ListNode(sum % 10);
                    result = current;
                } else {
                    current.next = new ListNode(sum % 10);
                    current = current.next;
                }

                if(null !=l1){
                    l1 = l1.next;
                }

                if(null !=l2){
                    l2 = l2.next;
                }
            }

            return result;
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
