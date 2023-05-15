package huazi2;

import java.util.*;

public class Main03 {
    static int[][] monsters;
    static int[][][] flag;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        monsters = new int[k][2];
        for (int i = 0; i < k; i++) {
            monsters[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int[] princess = {sc.nextInt(), sc.nextInt()};
        int[] king = {sc.nextInt(), sc.nextInt()};

        flag = new int[n][n][3];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                String[] strs = sc.next().split(" ");
                for (int k1 = 0; k1 < 3; k1++) {
                    flag[i][j][k1] = Integer.parseInt(strs[k1]);
                }
            }
        }
    }
}
