package com.blj.javawiki.algorithm.binarytree;

import java.util.List;

/**
 * 二叉树
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public class BinaryTreeMain {


    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(8,
                new BinaryTreeNode(8,
                        new BinaryTreeNode(9, null, null),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(4, null, null),
                                new BinaryTreeNode(7, null, null))),

                new BinaryTreeNode(7, null, null));

        BinaryTreeNode root2 =
                new BinaryTreeNode(8,
                        new BinaryTreeNode(5,
                                new BinaryTreeNode(2, null, null), new BinaryTreeNode(6, null, null)),
                        new BinaryTreeNode(15,
                                new BinaryTreeNode(11, null, null), new BinaryTreeNode(16,null,null)));

        BinaryTreeNodeImpl ibInaryTree = new BinaryTreeNodeImpl();

//        ibInaryTree.preOrderTraversal(root2);
        System.out.println();
//        ibInaryTree.mirror(root2);
//        ibInaryTree.preOrderTraversal(root2);
//        System.out.println();

//        boolean isHas = ibInaryTree.hasSubtree(root, root2);
//        System.out.println("isTree2HasTree2=" + isHas);


//        System.out.println("最小深度" + ibInaryTree.getMinDepth(root));
//        System.out.println("最大深度" + ibInaryTree.getMaxDepth(root));
//
//
//        System.out.println("总结点数" + ibInaryTree.countNumOfTreeNode(root));
//        System.out.println("叶子结点数" + ibInaryTree.countNumOfTreeNode(root));
//
//        System.out.println("是否平衡二叉树" + ibInaryTree.isBalanced(root2));
//        System.out.println("是否完全二叉树" + ibInaryTree.isCompleteBinaryTree(root2));
//        System.out.println("是否满二叉树" + ibInaryTree.isFullBinaryTree(root2));
//        System.out.println("中序遍历-非递归-二叉树" + ibInaryTree.inorderTraversalNoRecursion(root2));

        List<Integer> list = ibInaryTree.postOrderTraversalNoRecursion(root2);

        for(Integer item:list){
            System.out.print(item+" ");
        }
        System.out.println();

        ibInaryTree.levelOrderTraversal(root2);
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(3,null,null));
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(12,null,null));
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(14,null,null));
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(17,null,null));
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(18,null,null));
        ibInaryTree.insertNode(root2,new BinaryTreeNode<>(20,null,null));
        ibInaryTree.levelOrderTraversal(root2);
    }
}
