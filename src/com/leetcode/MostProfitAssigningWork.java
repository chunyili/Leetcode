package com.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
 * <p>
 * Now we have some workers. worker[i] is the ability of the ith worker,
 * which means that this worker can only complete a job with difficulty at most worker[i].
 * <p>
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * <p>
 * For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.
 * If a worker cannot complete any job, his profit is $0.
 * <p>
 * What is the most profit we can make?
 * <p>
 * Example 1:
 * <p>
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 * Notes:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new Pair<>(difficulty[i], profit[i]));
        }

        Collections.sort(jobs, Comparator.comparing(Pair::getKey));

        Arrays.sort(worker);

        int res = 0;
        int maxP = 0;

        int j = 0;

        for (int ability : worker) {
            while (j < difficulty.length && ability >= jobs.get(j).getKey()) {
                maxP = Math.max(maxP, jobs.get(j).getValue());
                j++;
            }

            res += maxP;
        }
        return res;
    }
}
