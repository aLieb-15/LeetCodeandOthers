package BaiduAgain;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxi = 0;
        int mini = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                maxi = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                mini = i;
            }
        }
        if (maxi > mini) {
            int ans = n - 1 - maxi + mini - 0;
            System.out.println(ans);
        } else {
            int ans = n - 1 - maxi + mini - 0 - 1;
            System.out.println(ans);
        }
    }
}
