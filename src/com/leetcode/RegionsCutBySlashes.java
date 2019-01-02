package com.leetcode;

/**
 * 959. Regions Cut By Slashes
 * Medium
 *
 * 90
 *
 * 23
 *
 * Favorite
 *
 * Share
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.
 * These characters divide the square into contiguous regions.
 *
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 *
 * Return the number of regions.
 *
 * Input:
 * [
 *   " /",
 *   "/ "
 * ]
 * Output: 2
 *
 * Example 2:
 *
 * Input:
 * [
 *   " /",
 *   "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 *
 * Example 3:
 *
 * Input:
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 *
 * Example 4:
 *
 * Input:
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 *
 * Example 5:
 *
 * Input:
 * [
 *   "//",
 *   "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 *
 *
 *
 * Note:
 *
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] is either '/', '\', or ' '.
 */
public class RegionsCutBySlashes {
    int count, n;
    int[] parent;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        parent = new int[n * n * 4];

        count = n * n * 4;

        for (int i = 0; i < n * n * 4; i++) {
            parent[i] = i;
        }

        // In case '/', top and left are contiguous, bottom and right are contiguous.
        // In case '\\', top and right are contiguous, bottom and left are contiguous.
        // In case ' ', all 4 parts are contiguous.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    union(g(i - 1, j, 2), g(i, j, 0)); // 把（i-1， j) cell的bottom 和 (i, j) cell的top union起来
                }
                if (j > 0) {
                    union(g(i, j - 1, 1), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 1), g(i, j, 2));
                }
            }
        }
        return count;
    }

    private int findParent(int[] parent, int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    private void union(int x, int y) {
        int fx = findParent(parent, x);
        int fy = findParent(parent, y);

        if (fx != fy) {
            parent[fx] = fy;
            count--;
        }
    }
    private int g(int i, int j, int k) {
        return (i * n + j) *  4 + k;
    }
}

// 把所有的cell都分成四个部分，'X' 形状，然后g函数求出每一个部分的编码，从而进行union find 操作，直到最后得到的联通块就是结果
// 这个解法把问题转化成了 counting number of islands.