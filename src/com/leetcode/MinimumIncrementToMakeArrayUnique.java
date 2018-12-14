package com.leetcode;


import java.util.Arrays;

/**
 *
 * 945. Minimum Increment to Make Array Unique
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 *
 * Return the least number of moves to make every value in A unique.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * Example 2:
 *
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 *
 * Note:
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 */
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int need = 0;
        int res = 0;

        for (int a : A) {
            res += Math.max(need - a, 0);
            need = Math.max(need, a) + 1;
        }
        return res;
    }

}
// 首先这个题要求把原来的数组排序，并且每个元素不能想同，所以需要从最小的元素开始扫描，后一个元素需要比前一个元素大1.
// 比较有意思的一点是用一个need来记录下一个需要的数字，而且当当前的数字是大于need的话，res += 0 need的起始点就变成了当前的元素 + 1
// Time complexity nlog(n) + n, n is A.length
//
