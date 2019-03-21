package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    // recurse
    private void preorder(List<Integer> res, Node node) {
        if (node == null) {
            return;
        }
        res.add(node.val);

        for (int i = 0; i < node.children.size(); i++) {
            preorder(res, node.children.get(i));
        }
    }

    public List<Integer> preorderIterate(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);

            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }

        return res;
    }
}
