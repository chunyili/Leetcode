package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        helper(res, 0, "", S);
        return res;
    }

    private void helper(List<String> res, int pos, String temp, String s) {
        if (pos == s.length()) {
            res.add(temp);
            return;
        }

        if (Character.isDigit(s.charAt(pos))) {
            helper(res, pos + 1, temp + s.charAt(pos), s);
        } else {
            helper(res, pos + 1, temp + Character.toUpperCase(s.charAt(pos)), s);
            helper(res, pos + 1, temp + Character.toLowerCase(s.charAt(pos)), s);
        }
    }

}
