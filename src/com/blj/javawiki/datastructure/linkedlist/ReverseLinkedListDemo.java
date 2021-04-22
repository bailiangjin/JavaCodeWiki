package com.blj.javawiki.datastructure.linkedlist;

/**
 * 反转单链表
 * Created by bailiangjin on 2017/6/30.
 */
public class ReverseLinkedListDemo {

    public static void main(String[] args) {

        Node head = new Node("1", new Node("2", new Node("3", null)));
//        Node insertHead = new Node("insert1", new Node("insert2", new Node("insert3", null)));

        printLinkedList(head);

        head = reverse(head);

        printLinkedList(head);
//
//        head = insert(head, insertHead);
//        printLinkedList(head);
//        head=delete(head,"2");

//        head=merge(insertHead,head);
//        printLinkedList(head);

    }

    private static void printLinkedList(Node head) {
        Node cur = head;

        while (null != cur) {
            System.out.print(cur.getValue() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    private static Node reverse(Node head) {
        Node pre = head;
        Node cur = head.getNext();
        Node next = null;
        while (null != cur) {
            next = cur.getNext();
            cur.setNext(pre);

            pre = cur;
            cur = next;
        }

        head.setNext(null);
        head = pre;

        return head;
    }

    public static Node merge(Node first, Node second) {
       if (null==first){
           return second;
       }

       if (null==second){
           return first;
       }

        Node firstEnd =first;
        while (firstEnd.getNext()!=null){
            firstEnd=firstEnd.getNext();
        }

        firstEnd.setNext(second);
        return first;

    }


    public static Node insert(Node head, Node nodeListToInsertHead) {
        Node aimNode = head;
        while (null != aimNode.getNext() && !"2".equals(aimNode.getValue())) {
            aimNode = aimNode.getNext();
        }

        Node aimNodeNext = aimNode.getNext();

        aimNode.setNext(nodeListToInsertHead);


        Node nodeListToInsertEnd = nodeListToInsertHead;
        while (null != nodeListToInsertEnd.getNext()) {
            nodeListToInsertEnd = nodeListToInsertEnd.getNext();
        }

        nodeListToInsertEnd.setNext(aimNodeNext);

        return head;

    }

    public static Node delete(Node head,String nodeToDeleteValue) {

        Node resultHead=head;
        Node preNode = head;
        Node curNode = head;


        while (null != curNode.getNext() && !nodeToDeleteValue.equals(curNode.getValue())) {
            preNode=curNode;
            curNode = curNode.getNext();
        }

        if(head.equals(curNode)){
            resultHead=curNode.getNext();
        }else {
            preNode.setNext(curNode.getNext());

        }
        curNode.setNext(null);

        return resultHead;

    }



}
