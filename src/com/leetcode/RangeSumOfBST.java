package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 938. Range Sum of BST
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */

public class RangeSumOfBST {

    // Solution I : inorder traversal, and added up the element within the range
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> res = new ArrayList<>();

        helper(res, root);

        int sum = 0;
        for (int a : res) {
            if (a >= L && a <= R) {
                sum += a;
            }

        }
        return sum;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }

    // Solution II
    public int rangeSumBSTII(TreeNode root, int L, int R) {
       if (root == null) {
           return 0;
       }
       int sum = 0;
       if (root.val < L) {
           return rangeSumBSTII(root.right, L, R);
       }

       if (root.val > R) {
           return rangeSumBSTII(root.left, L, R);
       }

       return root.val + rangeSumBSTII(root.left, L, R) + rangeSumBSTII(root.right, L, R);
    }
}
