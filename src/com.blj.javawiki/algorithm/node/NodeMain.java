package com.blj.javawiki.algorithm.node;

/**
 * 链表专题
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class NodeMain {


    /**
     * 单链表
     */
    public static class Node {
        int data;
        Node next;
    }


    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {

        if (null == head) {
            return null;
        }

        Node pre = null;
        Node next = null;

        while (null != head.next) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

    /**
     * 递归反转
     * @param head
     * @return
     */
    private static Node reverseNode2(Node head) {
        if (head == null || head.next == null) {
            //最终返回原来的尾结点
            return head;
        }
        Node next = head.next;
        //断开当前结点next指向
        head.next = null;
        //递归next结点对其进行相同操作
        Node reversedNode = reverseNode2(next);
        //next结点 指向当前节点
        next.next = head;
        return reversedNode;
    }

}
