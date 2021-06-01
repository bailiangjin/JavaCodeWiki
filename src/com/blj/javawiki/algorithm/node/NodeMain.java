package com.blj.javawiki.algorithm.node;

/**
 * 链表专题
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class NodeMain {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        ListNode head = node1;

        INodeOption<ListNode> nodeOption = new NodeOptionImpl();


//        Node reverseNode = nodeOption.reverseNode(head);
//        System.out.println(null == reverseNode ? "null" : reverseNode.data);

        ListNode entryNode = nodeOption.findEntryNodeOfLoop(head);
        System.out.println(null == entryNode ? "null" : entryNode.val);

        //Node findNode = findKthToTail(head, 6);
        //System.out.println(null == findNode ? "null" : findNode.data);

        ListNode head1 = new ListNode(-1, new ListNode(1, new ListNode(3, new ListNode(5, null))));
        ListNode head2 = new ListNode(0, new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10, null))))));

    }


    public ListNode mergeNode(ListNode node1, ListNode node2) {
        if (null == node1 && null == node2) {
            return null;
        }
        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }
        ListNode result = null;
        ListNode current = new ListNode(-1, null);
        while (null != node1 && null != node2) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            if (null == result) {
                result = current.next;
            }
        }

        if (null == node1) {
            current.next = node2;
        }
        if (null == node2) {
            current.next = node1;
        }

        return result;
    }
}
