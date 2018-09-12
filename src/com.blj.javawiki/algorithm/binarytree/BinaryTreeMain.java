package com.blj.javawiki.algorithm.binarytree;

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
                        new BinaryTreeNode(9,
                                new BinaryTreeNode(6, null, null), new BinaryTreeNode(7, null, null)),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(11, null, null), new BinaryTreeNode(12,null,null)));

        BinaryTreeNodeImpl ibInaryTree = new BinaryTreeNodeImpl();

//        ibInaryTree.preOrderTraversal(root2);
        System.out.println();
//        ibInaryTree.mirror(root2);
//        ibInaryTree.preOrderTraversal(root2);
//        System.out.println();

//        boolean isHas = ibInaryTree.hasSubtree(root, root2);
//        System.out.println("isTree2HasTree2=" + isHas);


        System.out.println("最小深度" + ibInaryTree.getMinDepth(root));
        System.out.println("最大深度" + ibInaryTree.getMaxDepth(root));


        System.out.println("总结点数" + ibInaryTree.countNumOfTreeNode(root));
        System.out.println("叶子结点数" + ibInaryTree.countNumOfTreeNode(root));

        System.out.println("是否平衡二叉树" + ibInaryTree.isBalanced(root2));
        System.out.println("是否完全二叉树" + ibInaryTree.isCompleteBinaryTree(root2));
        System.out.println("是否满二叉树" + ibInaryTree.isFullBinaryTree(root2));

    }
}
