public class Code01_RobotWalking {
    // 问题：假设有一个机器人在一个长度为N的数组中的start位置上
    // 机器人要行进到aim位置，并且有K步可走（必须走完）
    // 那么机器人有多少种方法到达aim处？
    public static void main(String[] args) {
        System.out.println(ways3(5, 2, 4, 6));
    }

    // 暴力递归
    public static int ways1(int N, int start, int aim, int K) {
        return process1(start, K, aim, N);
    }

    public static int process1(int cur, int rest, int aim, int N) {
        // base case
        if (rest == 0) {
            return (cur == aim) ? 1 : 0;
        }
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1, aim, N)
                + process1(cur + 1, rest - 1, aim, N);
    }

    // 傻缓存，自顶向下的动态规划，记忆化搜索
    // 关键是找清楚哪些参数决定了函数的返回值，把这些参数作为区分状态的标准
    public static int ways2(int N, int start, int aim, int K) {
        // 创建dp数组存储cur-rest代表的方法数的值
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;

        if (rest == 0) {
            ans = (cur == aim) ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public static int ways3(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;

        for (int rest = 1; rest <= K; rest++) {
            for (int cur = 1; cur <= N; cur++) {
                if (cur == 1) {
                    dp[cur][rest] = dp[cur + 1][rest - 1];
                } else if (cur == N) {
                    dp[cur][rest] = dp[cur - 1][rest - 1];
                } else {
                    dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
                }
            }
        }
        return dp[start][K];
    }
}