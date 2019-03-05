package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class CousinsinBinaryTree {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> level = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {

        if (x == y || root == null) {
            return false;
        }
        helper(root, 0);
        if (!level.containsKey(x) || !level.containsKey(y)) {
            return false;
        }

        return level.get(x) == level.get(y) && parent.get(x) != parent.get(y);

    }

    private void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        level.put(node.val, depth);

        if (node.left != null) {
            parent.put(node.left.val, node.val);
        }
        if (node.right != null) {
            parent.put(node.right.val, node.val);
        }
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);

    }
}


// Inorder traverse, put child val and parent val into a map
// Inorder traverse, put node val and level into a map
// time complexity O(n)
// space complexity O(n)