package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
 * return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
 * because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count_fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0) {
            return 0;
        }
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] d : dir) {
                    int nextX = cur[0] + d[0];
                    int nextY = cur[1] + d[1];

                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                        count_fresh--;
                    }
                }

            }
            level++;
        }
        return count_fresh == 0 ? level -1 : -1;

    }

}
