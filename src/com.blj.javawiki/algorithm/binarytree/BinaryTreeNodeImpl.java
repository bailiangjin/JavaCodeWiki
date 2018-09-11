package com.blj.javawiki.algorithm.binarytree;

/**
 * 二叉树 算法实例
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public class BinaryTreeNodeImpl implements IBInaryTree {
    @Override
    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (null == root1 || null == root2) {
            return false;
        }

        boolean result = false;

        if (root1.value == root2.value) {
            result = isTree1HasTree2(root1, root2);
        }

        if (!result) {
            result = hasSubtree(root1.left, root2);
        }

        if (!result) {
            result = hasSubtree(root1.right, root2);
        }

        return result;
    }


    public boolean isTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (null == root2) {
            return true;
        }

        if (null == root1) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return isTree1HasTree2(root1.left, root2.left)
                && isTree1HasTree2(root1.right, root2.right);
    }


    /**
     * 先序遍历
     *
     * @param root
     */
    @Override
    public void preOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    @Override
    public void inorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value);
            inorderTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    @Override
    public void postOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value);
        }
    }

    @Override
    public void mirror(BinaryTreeNode root) {
        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            return;
        }

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

    }

    @Override
    public boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (null == t1 && null == t2) {
            return true;
        }

        if (null == t1 || null == t2) {
            return false;
        }

        if (t1.value == t2.value) {
            return true;
        }

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    @Override
    public boolean isSameTreeNode(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (null == t1 && null == t2) {
            return true;
        }

        if (null == t1 || null == t2) {
            return false;
        }

        if (t1.value == t2.value) {
            return true;
        }

        return isSameTreeNode(t1.left, t2.left) && isSameTreeNode(t1.right, t2.right);
    }


    /**
     * @param root
     * @return
     */
    @Override
    public int getMaxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    @Override
    public int getMinDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        return Math.min(left, right) + 1;
    }

    @Override
    public int countNumOfTreeNode(BinaryTreeNode root) {
        if (root == null) {
            return 0;

        }
        int left = countNumOfTreeNode(root.left);
        int right = countNumOfTreeNode(root.right);
        return left + right + 1;
    }


    @Override
    public int countNumberOfNoChildNode(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        return countNumberOfNoChildNode(root.left) + countNumberOfNoChildNode(root.right);

    }


}
