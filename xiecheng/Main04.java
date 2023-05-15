package xiecheng;

import java.util.Scanner;

public class Main04 {
    public static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            ans += (arr[i] + 1) * arr[i] / 2;
            ans %= MOD;
        }
        for (int k = 1; k < n; k++) {
            for (int i = k; i < n - k; i++) {
                for (int j = 1; j <= k; j++) {
                    if (j == k) {
                        ans += Math.min(arr[i - j], arr[i + j]);
                        ans %= MOD;
                    } else {
                        if (arr[i - j] != arr[i + j]) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
