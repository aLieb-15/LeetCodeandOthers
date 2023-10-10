package ByteDance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] arrays = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        int[] resultPrefix = findMaxORPrefix(arrays, n, k);
        for (int i = 0; i < k; i++) {
            System.out.print(resultPrefix[i] + " ");
        }
    }

    public static int[] findMaxORPrefix(int[][] arrays, int n, int k) {
        int[] resultPrefix = new int[k];

        // 从高位到低位依次确定每个位置的值
        for (int bit = 30; bit >= 0; bit--) {
            int count = 0;
            int[] prefix = new int[k];

            // 尝试将第 i 个数组的前缀的当前位（bit 位）置为 1
            for (int i = 0; i < 3; i++) {
                int[] currArray = arrays[i];
                int currCount = 0;

                // 统计前缀中当前位为 1 的个数
                for (int j = 0; j < n; j++) {
                    if (((currArray[j] >> bit) & 1) == 1) {
                        currCount++;
                    }
                }

                // 如果当前位为 1 的个数超过 k，说明无法将该位置为 1，跳过该数组
                if (currCount > k) {
                    continue;
                }

                // 将该数组的前缀的当前位置为 1
                for (int j = 0; j < currCount; j++) {
                    prefix[count++] = currArray[j];
                }
            }

            // 如果统计的前缀中的数的个数小于 k，说明当前位无法置为 1，继续下一位
            if (count < k) {
                continue;
            }

            // 将结果前缀的当前位置为 1
            for (int i = 0; i < k; i++) {
                resultPrefix[i] |= (1 << bit);
                resultPrefix[i] |= prefix[i];
            }

            // 结果已经找到，直接返回
            return resultPrefix;
        }

        return resultPrefix;
    }
}
