package com.blj.javawiki.algorithm.node;

/**
 * 链表专题
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class NodeMain {




    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        NodeOptionImpl nodeOption=new NodeOptionImpl();

        Node reverseNode = nodeOption.reverseNode(head);
        System.out.println(null == reverseNode ? "null" : reverseNode.data);

        //Node findNode = findKthToTail(head, 6);
        //System.out.println(null == findNode ? "null" : findNode.data);

    }



}
