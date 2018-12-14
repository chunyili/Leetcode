package com.leetcode;

import java.util.Arrays;

/**
 *
 * 947. Most Stones Removed with Same Row or Column
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class MostStonesRemovedWithSameRowOrColoum {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        UnionFind uf = new UnionFind(20000);

        for (int[] s : stones) {
            uf.union(s[0], s[1] + 10000);
        }

        return n - uf.count;
    }

}

class UnionFind {
    int[] parent;

    int count = 0;
    public UnionFind(int n) {
        parent = new int[n];

        Arrays.fill(parent, -1);
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            parent[fx] = fy;
            count--;
        }
    }

    private int find(int p) {
        if (parent[p] == -1) {
            parent[p] = p;
            count++;
        }

        return p == parent[p] ? p : find(parent[p]);
    }

}
/**
 * 1. 数岛屿问题
 *
 * 如果两个石头在同行或者同列，两个石头就是连接的。连在一起的石头，可以组成一个连通图。每一个连通图至少会剩下1个石头。
 * 所以我们希望存在一种思路，每个连通图都只剩下1个石头。
 * 这样这题就转化成了数岛屿的问题。
 *
 * Tricky part :
 * 实际上我们对行列的搜索，没有任何本质区别。
 * 只不过是因为同一个index，可能是行也可能是列，所以我们做了区分。
 * 实际上，只要我们能区分行列的index，代码就可以缩减一半了。
 *
 * 行的index我们还可以用0～N - 1，列的index我们使用N～2N-1就可以了。
 *
 *
 * 所以在列坐标 + 10000 以示和行坐标的区分
 *
 *
 * One sentence to solve:
 * Connected stones can be reduced to 1 stone,
 * the maximum stones can be removed = stones number - islands number.
 * so just count the number of "islands".
 *
 */

