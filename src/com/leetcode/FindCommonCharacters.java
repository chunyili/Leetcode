package com.leetcode;

import java.util.*;

/***
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times,
 * you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        int[] count = new int[26];

        Arrays.fill(count, Integer.MAX_VALUE);

        for (String a : A) {
            int[] localCount = new int[26];

            for (char c : a.toCharArray()) {
                localCount[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], localCount[i]);
            }
        }

        for (int i = 0; i < 26; ++i) {
            while (count[i]-- > 0) { res.add("" + (char)(i + 'a')); }
        }

        return res;
    }
}

