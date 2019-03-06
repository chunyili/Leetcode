package com.leetcode;


/**
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z':
 * a value of 0 represents 'a',
 * a value of 1 represents 'b', and so on.
 * <p>
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example,
 * "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 1000.
 * Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }

        return dfs(root);

    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }

        String left = dfs(node.left);
        String right = dfs(node.right);

        if (left.length() > 0 && right.length() > 0) {
            return (left.compareTo(right) < 0 ? left : right) + (char) (node.val + 'a');
        } else if (left.length() > 0) {
            return left + (char) (node.val + 'a');
        } else {
            return right + (char) (node.val + 'a');
        }

    }
}
// post-order traverse
// time complexity O(n)
