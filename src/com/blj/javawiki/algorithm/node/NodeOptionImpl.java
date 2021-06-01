package com.blj.javawiki.algorithm.node;

import java.util.ArrayList;
import java.util.List;

/**
 * node操作实现类
 *
 * @author bailiangjin
 * @date 2018/9/7
 */
public class NodeOptionImpl implements INodeOption<ListNode> {

    @Override
    public ListNode reverseNode(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;

        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Override
    public ListNode reverseNodeRecursive(ListNode head) {
        if (head == null || head.next == null) {
            //最终返回原来的尾结点
            return head;
        }
        ListNode next = head.next;
        //断开当前结点next指向
        head.next = null;
        //递归next结点对其进行相同操作
        ListNode reversedNode = reverseNodeRecursive(next);
        //next结点 指向当前节点
        next.next = head;
        return reversedNode;
    }

    @Override
    public ListNode findKthToTail(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    @Override
    public ListNode mergeNode(ListNode aHead, ListNode bHead) {

        if (null == aHead) {
            return bHead;
        } else if (null == bHead) {
            return aHead;
        }

        ListNode mergeHead = null;

        if (aHead.val < bHead.val) {
            mergeHead = aHead;
            mergeHead.next = mergeNode(aHead.next, bHead);
        } else {
            mergeHead = bHead;
            mergeHead.next = mergeNode(bHead.next, aHead);
        }
        return mergeHead;
    }


    @Override
    public ListNode findEntryNodeOfLoop(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode meetingNode = findMeetingNodeOfLoop(head);
        if (null == meetingNode) {
            return null;
        }

        ListNode pNode = meetingNode.next;
        int nodeNumber = 1;
        while (pNode != meetingNode) {
            pNode = pNode.next;
            nodeNumber++;
        }

        ListNode aNode = head;
        ListNode bNode = head;

        int i = 0;
        while (i < nodeNumber) {
            aNode = aNode.next;
            i++;
        }
        while (aNode != bNode) {
            aNode = aNode.next;
            bNode = bNode.next;
        }
        return bNode;


    }

    @Override
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode next = head;
        while (null != next) {
            if (val == next.val) {
                if (pre == null) {
                    return next.next;
                } else {
                    pre.next = next.next;
                }
                break;
            }
            pre = next;
            next = next.next;
        }
        return head;
    }

    /**
     * 寻找快慢指针的相会节点
     *
     * @param head
     * @return
     */
    public ListNode findMeetingNodeOfLoop(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (null != slow && null != fast) {

            if (slow == fast) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;

            if (null != fast) {
                //快指针走两步
                fast = fast.next;
            }
        }
        return null;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> numberList = new ArrayList<>();
        ListNode curHead = head;
        while (null!=curHead) {
            numberList.add(curHead.val);
            curHead = curHead.next;
        }
        int length = numberList.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = numberList.get(length-1 -i);
        }
        return result;
    }

    public int[] reversePrint(ListNode node, int count) {
        if (null == node) {
            return new int[0];
        }
        if (null != node.next) {
            int[] array = reversePrint(node.next, count + 1);
            array[array.length - 1 - count] = node.val;
            return array;
        } else {
            int[] array = new int[count + 1];
            array[0] = node.val;
            return array;
        }
    }
}
