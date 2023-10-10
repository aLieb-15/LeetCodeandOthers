package BaiduAgain;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a % 2 == 1) {
                a--;
            }
            if (b % 2 == 0) {
                b--;
            }
            if (x < y) {
                long sub = y - x;
                long ans = 0;
                if (sub % 2 == 1) {
                    sub += 1;
                    ans = 1;
                }
                long mod = sub % a;
                long di = sub / a;
                ans += di + (mod == 0 ? 0 : 1);
                System.out.println(ans);
            } else if (x == y) {
                System.out.println(0);
            } else {
                long sub = x - y;
                long mod = sub % b;
                long di = sub / b;
                long ans = di;
                if (mod != 0) {
                    if (mod % 2 == 1) {
                        ans ++;
                    } else {
                        ans += 2;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
