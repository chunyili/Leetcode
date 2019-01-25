package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. Subarray Sums Divisible by K
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int res = 0;

        Map<Integer, Integer> count = new HashMap<>();

        count.put(0, 1);
        for (int a : A) {
            sum = (sum + a % K + K) % K; // why (sum + a % k + k ) % k, cause mod can be negative and + K ensure the mod to be positive
            res += count.getOrDefault(sum, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);

        }
        return res;
    }
}
