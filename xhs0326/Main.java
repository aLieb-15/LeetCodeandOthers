package xhs0326;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 第三题 涂色
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] opsL = new int[M];
        int[] opsR = new int[M];
        int[] opsN = new int[M];
        // 左边界
        for (int i = 0; i < M; i++) {
            opsL[i] = sc.nextInt();
        }
        // 右边界
        for (int i = 0; i < M; i++) {
            opsR[i] = sc.nextInt();
        }
        String s = sc.next();
        char[] ops = s.toCharArray();
        // 参数
        for (int i = 0; i < M; i++) {
            opsN[i] = sc.nextInt();
        }
        sc.close();
        // M个操作，循环M次
        for (int i = 0; i < M; i++) {
            char c = ops[i];
            int l = opsL[i];
            int r = opsR[i];
            int n = opsN[i];
            if (c == '|') {
                for (int j = l; j <= r; j++) {
                    arr[j] = arr[j] | n;
                }
            } else if (c == '&') {
                for (int j = l; j <= r; j++) {
                    arr[j] = arr[j] & n;
                }
            } else {
                for (int j = l; j <= r; j++) {
                    arr[j] = n;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]);
        }
    }


    // // 第二题 K排序
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int T = sc.nextInt();
    //     for (int i = 0; i < T; i++) {
    //         // 读取第i组数据存入数组
    //         int n = sc.nextInt();
    //         int k = sc.nextInt();
    //         int[] nums = new int[n];
    //         for (int j = 0; j < n; j++) {
    //             nums[j] = sc.nextInt();
    //         }
    //         System.out.println(myKSort(nums, k));
    //     }
    // }

    // public static int myKSort(int[] a, int k) {
    //     int len = a.length;
    //     int[] temp = new int[len];
    //     for (int i = 0; i < len; i++) {
    //         temp[i] = a[i];
    //     }
    //     Arrays.sort(temp);
    //     int index = 0;
    //     int cnt = 0;
    //     for (int i = 0; i < len; i++) {
    //         if (a[i] == temp[i]) {
    //             index ++;
    //             cnt ++;
    //         }
    //     }
    //     if ((len - cnt) % k == 0) {
    //         return (len - cnt) / k;
    //     } else {
    //         return (len - cnt) / k + 1;
    //     }
    // }


    // 第一题 ac 凯撒密码
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int N = sc.nextInt();
    //     String S = sc.next();
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < N; i++) {
    //         char c = S.charAt(i);
    //         if (c == 'a') {
    //             c = 'x';
    //         } else if (c == 'b') {
    //             c = 'y';
    //         } else if (c == 'c') {
    //             c = 'z';
    //         } else {
    //             c -= 3;
    //         }
    //         sb.append(c);
    //     }
    //     System.out.println(sb.toString());
    // }
}
