package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * A robot on an infinite grid starts at point (0, 0) and faces north.
 * The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square instead
 * (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        int[][] dir = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};


        int res = 0; int d = 0;
        int x = 0; int y = 0;

        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {

                while (c > 0 && !set.contains((x + dir[d][0]) + " " + (y + dir[d][1]))) {
                    x += dir[d][0];
                    y += dir[d][1];
                    c--;

                }
            }
            res = Math.max(res, x * x + y * y);
        }


        return res;
    }
}

// make dir[][] clockwise and according to turn left or turn right, make the index d++ or d--
// x y refer to indices of current position
