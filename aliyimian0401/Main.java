package aliyimian0401;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] A = {9, 1, 2, 3, 9};
        int k = 3;
        System.out.println(subStringArr(A, k));
    }

    public static int subStringArr(int[] A, int k) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }
        System.out.println(Arrays.toString(preSum));
        int[][] dp = new int[n][k];
        for (int t = 0; t < k; t++) {
            for (int i = 0; i < n; i++) {
                dp[i][t] = Integer.MAX_VALUE;
                if (t == 0) {
                    dp[i][t] = (preSum[i + 1]) / (i + 1);
                } else {
                    for (int j = i; j >= t; j--) {
                        dp[i][t] = Math.min(dp[i][t], dp[j - 1][t - 1] + (preSum[i + 1] - preSum[j]) / (i - j + 1));
                    }
                }
            }
        }
    
        return dp[n - 1][k - 1];
    }
}
