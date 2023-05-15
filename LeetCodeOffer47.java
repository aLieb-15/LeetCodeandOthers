import java.rmi.ConnectIOException;

public class LeetCodeOffer47 {
    public static void main(String[] args) {

    }

    /**
     * 在m*n的棋盘的每一格都有一个礼物，每个礼物都有一定的价值（>0）
     * 从棋盘的左上角开始拿格子里的礼物，每次只能向下或向右走一步
     * 直到到达棋盘的右下角，求能拿到的礼物的最大价值？
     * m>0, n>0
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 设计dp[i][j]：已经(i, j)位置的情况下，已经能拿到的礼物的最大价值
        // 初始化为0
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
