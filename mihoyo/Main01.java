package mihoyo;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        int n = scanner.nextInt();

        // 读取数组 a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 读取数组 b
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;

        // 遍历比特位
        for (int bit = 31; bit >= 0; bit--) {
            int mask = 1 << bit;
            int maxWithBit = max | mask;

            int sumA = 0;
            for (int num : a) {
                if ((num & mask) != 0) {
                    sumA += num;
                }
            }

            int sumB = 0;
            for (int num : b) {
                if ((num & mask) != 0) {
                    sumB += num;
                }
            }

            if ((sumA ^ sumB) > max && sumA != 0 && sumB != 0) {
                max = sumA ^ sumB;
            }
        }

        System.out.println(max);
    }
}
