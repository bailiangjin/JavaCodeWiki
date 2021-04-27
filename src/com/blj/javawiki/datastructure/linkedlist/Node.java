package com.blj.javawiki.datastructure.linkedlist;

/**
 * Created by bailiangjin on 2017/6/30.
 */
public class Node {

   private String value;

   private Node next;


    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
