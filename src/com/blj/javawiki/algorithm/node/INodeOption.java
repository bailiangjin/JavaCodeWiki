package com.blj.javawiki.algorithm.node;

/**
 * 单链表操作接口
 *
 * @author bailiangjin
 * @date 2018/9/7
 */
public interface INodeOption<Node extends Object> {

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    Node reverseNode(Node head);

    /**
     * 反转单链表-递归方式
     *
     * @param head
     * @return
     */
    Node reverseNodeRecursive(Node head);


    /**
     * 找到倒数第k个结点
     *
     * @param head
     * @param k
     * @return
     */
    Node findKthToTail(Node head, int k);

    /**
     * 合并有序链表
     *
     * @param aHead
     * @param bHead
     * @return
     */
    Node mergeNode(Node aHead, Node bHead);

    /**
     * 寻找环的入口
     * @param head
     * @return
     */
    Node findEntryNodeOfLoop(Node head);

    /**
     * 删除链表节点
     * @param head 链表head
     * @param val 要删除的节点值
     * @return head
     */
    Node deleteNode(Node head, int val);

}
