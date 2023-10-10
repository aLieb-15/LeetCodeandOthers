package ByteDance;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        int result = countOperations(s, t, k);
        System.out.println(result);
    }

    public static int countOperations(String s, String t, int k) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        int result = dp[m][n];
        // 计算 (2^k - 1)^n % MOD
        long power = modPow(2, k, MOD) - 1;
        result = (int) ((long) result * modPow(power, n, MOD) % MOD);
        return result;
    }

    // 计算 a 的 b 次方对 MOD 取模的结果
    public static int modPow(long a, int b, int MOD) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b /= 2;
        }
        return (int) result;
    }
}
