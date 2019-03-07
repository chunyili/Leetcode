package com.leetcode;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;

        char[] chars = S.toCharArray();
        while (i < j) {
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                swap(chars, i, j);
                i++;
                j--;
            } else if (!Character.isLetter(chars[i])) {
                i++;
            } else {
                j--;
            }
        }

        return new String(chars);
    }
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
