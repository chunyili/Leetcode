package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * <p>
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 * <p>
 * Return the minimum number of operations needed to display the number Y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 * <p>
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 * <p>
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * Example 4:
 * <p>
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }
}

//time complexity is O(log(Y/X)).
// Considering how to change Y to X
// Operation 1: Y = Y / 2 if Y is even
// Operation 2: Y = Y + 1
//
//
// Explanation:
//
// Obviously,
// If Y <= X, we won't do Y / 2 anymore.
// We will increase Y until it equals to X
//
// So before that, while Y > X, we'll keep reducing Y, until it's smaller than X.
// If Y is odd, we can do only Y = Y + 1
// If Y is even, if we plus 1 to Y, then Y is odd, we need to plus another 1.
// And because (Y + 1 + 1) / 2 = (Y / 2) + 1, 3 operations are more than 2.
// We always choose Y / 2 if Y is even.
