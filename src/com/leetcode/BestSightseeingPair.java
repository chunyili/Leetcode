package com.leetcode;

/**
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot,
 * and two sightseeing spots i and j have distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {
    // Time out
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, A[i] + A[j] + i - j);
            }
        }
        return max;

    }

    public int maxScoreSightseeingPairII(int[] A) {
        int max = A[0] + 0;
        int i = 0;

        for (int j = 1; j < A.length; j++) {
            max = Math.max(max, A[i] + A[j] + i - j);

            if (A[i] + i < A[j] + j)  {
                i = j;
            }
        }
        return max;
    }
}
