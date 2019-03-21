package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 *
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {


        if (root == null) {
            return res;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }


}
