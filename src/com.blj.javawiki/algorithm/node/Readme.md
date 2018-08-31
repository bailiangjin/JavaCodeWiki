# 链表总结

## 反转单链表
面试基本算法题之一，重点 pre和next while循环

代码

```$xslt
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
```