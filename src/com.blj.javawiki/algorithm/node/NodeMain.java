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
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }


    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));

        Node reverseNode = reverseNode(head);
        System.out.println(null == reverseNode ? "null" : reverseNode.data);

        //Node findNode = findKthToTail(head, 6);
        //System.out.println(null == findNode ? "null" : findNode.data);

    }


    /**
     * 反转单链表
     *
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
     *
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


    /**
     * 查找倒数第K个节点
     *
     * @param head
     * @param k
     * @return
     */
    private static Node findKthToTail(Node head, int k) {

        if (null == head) {
            return null;
        }

        Node aHead = head;
        Node bHead = null;

        int i = 0;
        while (i < k - 1) {
            if (null != aHead.next) {
                aHead = aHead.next;
            } else {
                return null;
            }
            i++;
        }

        bHead = head;

        while (aHead.next != null) {
            aHead = aHead.next;
            bHead = bHead.next;
        }
        return bHead;


    }

}
