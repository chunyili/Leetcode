package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : (A + " " + B).split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                res.add(key);
            }
        }

        return res.toArray(new String[0]);
    }
}

// uncommon word = words that appears only once
