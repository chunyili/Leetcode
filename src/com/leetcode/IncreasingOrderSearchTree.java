package com.leetcode;

public class IncreasingOrderSearchTree {
    private TreeNode prev = null;
    private TreeNode res = null;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);

        if (res == null) {
            res = node;
        } else {
            prev.right = node;
        }

        prev = node;
        node.left = null;
        helper(node.right);
    }
}
