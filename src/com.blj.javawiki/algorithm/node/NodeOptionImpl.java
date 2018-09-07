package com.blj.javawiki.algorithm.node;

/**
 * node操作实现类
 *
 * @author bailiangjin
 * @date 2018/9/7
 */
public class NodeOptionImpl implements INodeOption<Node> {
    @Override
    public Node reverseNode(Node head) {
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

    @Override
    public Node reverseNodeRecursive(Node head) {
        if (head == null || head.next == null) {
            //最终返回原来的尾结点
            return head;
        }
        Node next = head.next;
        //断开当前结点next指向
        head.next = null;
        //递归next结点对其进行相同操作
        Node reversedNode = reverseNodeRecursive(next);
        //next结点 指向当前节点
        next.next = head;
        return reversedNode;
    }

    @Override
    public Node findKthToTail(Node head, int k) {
        if (null == head) {
            return null;
        }

        Node aHead = head;
        Node bHead = head;

        int i = 0;
        while (i < k - 1) {
            if (null != aHead.next) {
                aHead = aHead.next;
            } else {
                return null;
            }
            i++;
        }

        while (aHead.next != null) {
            aHead = aHead.next;
            bHead = bHead.next;
        }
        return bHead;
    }

    @Override
    public Node mergeNode(Node aHead, Node bHead) {

        if (null == aHead) {
            return bHead;
        } else if (null == bHead) {
            return aHead;
        }

        Node mergeHead=null;

        if(aHead.data<bHead.data){
            mergeHead=aHead;
            mergeHead.next=mergeNode(aHead.next,bHead);
        }else {
            mergeHead=bHead;
            mergeHead.next=mergeNode(bHead.next,aHead);
        }
        return mergeHead;
    }
}
