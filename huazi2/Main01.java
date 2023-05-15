package huazi2;

import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bits = new int[N];
        int index = 0;
        int epoch = N / 16 + 1;
        for (int i = 0; i < epoch; i++) {
            int tmp = Integer.valueOf(sc.next().substring(2, 6), 16);
            String bitString = Integer.toBinaryString(tmp);
            // 补0
            if (bitString.length() < 16) {
                for (int m = 0; m < 16 - bitString.length(); m++) {
                    bits[index++] = 0;
                }
            }
            for (int j = 0; j < bitString.length(); j++) {
                if (index >= N) {
                    break;
                }
                bits[index] = Integer.valueOf(bitString.substring(j, j+1), 10);
                index++;
            }
        }
        index = 0;
        // 找出最大的洞
        int maxHole = 0;
        int maxIndex = -1;
        for (int i = 0; i < N; i++) {
            if (bits[i] == 0) {
                int tmpSize = 1;
                int j = i + 1;
                while (bits[j] == 0) {
                    tmpSize++;
                    j++;
                }
                if (tmpSize >= maxHole) {
                    maxHole = tmpSize;
                    maxIndex = i;
                }
                i = j - 1;
            }
        }
        if (bits[0] == 0) {
            System.out.println("-" + maxHole);
        }
    }
}
