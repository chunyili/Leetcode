package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. Shortest Bridge
 *
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally
 * connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 */
public class ShortestBridge {

    private  int[][] dir = new int[][]{{-1, 0},{1, 0},{0, 1},{0, -1}};
    private int m;
    private int n;
    public int shortestBridge(int[][] A) {
        this.m = A.length;
        this.n = A[0].length;

        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // First find one island
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    dfs(A, i, j, visited, queue);
                    found = true;
                    break;
                }
            }
        }


        int res = 0;

        // Then using bfs to find the shortest path to expand the island until they meet each other

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] d : dir) {
                    int nextX = cur[0] + d[0];
                    int nextY = cur[1] + d[1];

                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                        if (A[nextX][nextY] == 1) {
                            return res;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            res++;
        }

        return -1;

    }


    private void dfs(int[][] A, int x, int y, boolean[][] visited, Queue<int[]> queue) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || A[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        for (int[] d : dir) {
            dfs(A, x + d[0], y + d[1], visited, queue);
        }
    }

}

// Time Complexity : O(m * n) ?
