public class LeetCodeFaceTest13 {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        // System.out.println(canGetIn(35, 37, 18));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        return dfs(board, 0, 0, k);
    }

    public static int dfs(int[][] board, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return 0;
        }
        if (!canGetIn(i, j, k)) {
            return 0;
        }
        int count = 0;
        // 没有访问过的格子
        if (board[i][j] == 0) {
            count++;
            board[i][j] = 1;
            count =count + dfs(board, i + 1, j, k) + dfs(board, i, j + 1, k) + dfs(board, i - 1, j, k)
         + dfs(board, i, j - 1, k);
        }
        return count;
    }

    public static boolean canGetIn(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        System.out.println("sum:" + sum);
        return sum <= k;
    }
}
