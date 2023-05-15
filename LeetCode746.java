/*
 * 以最小的代价爬楼梯，动态规划解法
*/
public class LeetCode746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];
        for (int i = cost.length - 3; i >= 0; i--) {
            int oneStep = 0, twoStep = 0;
            // 一步必定不会越界
            oneStep = cost[i] + dp[i + 1];
            twoStep = cost[i] + dp[i + 2];
            dp[i] = Math.min(oneStep, twoStep);
        }
        return Math.min(dp[0], dp[1]);
    }
}
