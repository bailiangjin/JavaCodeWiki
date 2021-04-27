package com.blj.javawiki;

import java.util.LinkedList;

/**
 * Created by bailiangjin on 2017/6/29.
 */
public class QueueDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>() {{

            add("1");
            add("2");
            add("3");
            add("4");
        }};

        System.out.println(linkedList);
        linkedList.add("5");
        System.out.println(linkedList);

        System.out.println(linkedList.element());
        System.out.println(linkedList);

        while (null != linkedList.poll()) {
            System.out.println(linkedList);
        }

        int i = 10;
    }
}
