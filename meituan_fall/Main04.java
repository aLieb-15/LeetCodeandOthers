package meituan_fall;

import java.util.*;

public class Main04 {
    private static int MOD = (int)1e9 + 7;
    private static int n, k;
    private static int[] arr;
    private static long[][][] dp;
    private static Map<String, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp = new long[n + 1][k + 1][n];
        System.out.println(dfs(0, k, -1));
    }

    public static long dfs(int i , int t, int pre) {
        if (i == n) {
            return t == 0 ? 1 : 0;
        }
        String k = i + "_" + t + "_" + pre;
        if (map.containsKey(k)) {
            return map.get(k);
        }
        
        long ans = 0; 
        if (pre == -1) {
            if (t > 0) {
                ans += dfs(i + 1, t, i) % MOD;
                ans += dfs(i + 1, t - 1, -1) % MOD;
            } else {
                ans += dfs(i + 1, t, i) % MOD;
            }
        } else {
            if (arr[i] % arr[pre] == 0 || arr[pre] % arr[i] == 0) {
                ans += dfs(i + 1, t, pre) % MOD;
                if (t > 0) {
                    ans += dfs(i + 1, t - 1, pre) % MOD;
                }
            } else {
                if (t > 0) {
                    ans += dfs(i + 1, t - 1, pre) % MOD;
                } else {
                    return 0;
                }
            }
            dp[i][t][pre] = ans;
        }
        map.put(k, ans % MOD);
        return ans % MOD;
    }
}
