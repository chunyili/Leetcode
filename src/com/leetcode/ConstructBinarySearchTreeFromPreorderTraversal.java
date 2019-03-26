package com.leetcode;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {

        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);

        int i = start + 1;

        // Note i <= end
        while (i <= end && preorder[i] < root.val) {
            i++;
        }

        root.left = helper(preorder, start + 1, i - 1);
        root.right = helper(preorder, i, end);

        return root;
    }
}
