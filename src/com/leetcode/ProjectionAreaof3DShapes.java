package com.leetcode;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * <p>
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * <p>
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * <p>
 * Return the total area of all three projections.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 5
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation:
 * Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 * <p>
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 8
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < grid.length; i++) {
            int mx = 0; int my = 0;
            for (int j = 0; j < grid[0].length; j++) {
                mx = Math.max(mx, grid[j][i]);
                my = Math.max(my, grid[i][j]);
                if (grid[i][j] > 0) {
                    z += 1;
                }
            }
            x += mx;
            y += my;

        }
        return x + y + z;
    }
}
// Note: for a N * N grid, i & j limits are both grid.length.
//
// get max out of grid [j] [i] (j = 0 ~ grid.length), the projection in x direction (on y-z plane)
// get max out of grid[i][j] (j = 0 ~ grid.length), the projection in y direction (on x-z plane)
