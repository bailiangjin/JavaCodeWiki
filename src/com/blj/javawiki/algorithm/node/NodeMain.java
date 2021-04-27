package com.blj.javawiki.algorithm.node;

/**
 * 链表专题
 *
 * @author bailiangjin
 * @date 2018/8/31
 */
public class NodeMain {


    public static void main(String[] args) {

        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        Node head = node1;

        INodeOption<Node> nodeOption = new NodeOptionImpl();


//        Node reverseNode = nodeOption.reverseNode(head);
//        System.out.println(null == reverseNode ? "null" : reverseNode.data);

        Node entryNode = nodeOption.findEntryNodeOfLoop(head);
        System.out.println(null == entryNode ? "null" : entryNode.data);

        //Node findNode = findKthToTail(head, 6);
        //System.out.println(null == findNode ? "null" : findNode.data);

        Node head1 = new Node(-1, new Node(1, new Node(3, new Node(5, null))));
        Node head2 = new Node(0, new Node(2, new Node(4, new Node(6, new Node(8, new Node(10, null))))));

    }


    public Node mergeNode(Node node1, Node node2) {
        if (null == node1 && null == node2) {
            return null;
        }
        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }
        Node result = null;
        Node current = new Node(-1, null);
        while (null != node1 && null != node2) {
            if (node1.data <= node2.data) {
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
