package HuaweiAgain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main02 {
    private static int ans = Integer.MAX_VALUE;
    private static int[][] grid;
    private static int m, n;
    private static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static Deque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                queue.addLast(new int[] { i, 0, 0 });
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.pollFirst();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];
            for (int[] di : dir) {
                int nx = x + di[0];
                int ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (ny == n - 1) {
                    ans = Math.min(ans, step + 1);
                    break;
                }
                queue.addLast(new int[]{nx, ny, step + 1});
            }

        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }

    }
}
