package com.leetcode;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Return the total surface area of the resulting shapes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    res += grid[i][j] * 4 + 2;
                }
                if (i > 0) {
                    res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j > 0) {
                    res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        return res;
    }
}
// For each tower, its surface area is 4 * v + 2
// However, 2 adjacent tower will hide the area of connected part.
// The hidden part is min(v1, v2) and we need just minus this area * 2
//
// Time Complexity:
// O(N^2)