package qianxin;

public class Main01 {
    public static void main(String[] args) {
        
    }

    public static int DagPathNum (int[][] nodes) {
        // write code here
        int len = nodes.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j : nodes[i]) {
                dp[j] += dp[i];
            }
        }
        return dp[len - 1];
    }
}
