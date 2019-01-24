package com.leetcode;

/**
 * 977. Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {

        if (A == null || A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        int index = A.length - 1;
        int i = 0; int j = A.length - 1;

        while (i <= j) {
            if (Math.abs(A[i]) < Math.abs(A[j])) {
                 res[index--] = getSquareRes(A[j]);
                 j--;
            } else {
                res[index--] = getSquareRes(A[i]);
                i++;
            }

        }

        return res;
    }

    private int getSquareRes(int n) {
        return n * n;
    }
}

// Time complexity O(n) n is A.length
