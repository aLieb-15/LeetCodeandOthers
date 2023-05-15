public class LeetCode1025 {
    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }

    public static boolean divisorGame(int n) {
        // 动态规划解法↓
        if (n == 1) {
            return false;
        }
        // dp数组，行标为0表示由alice出手，1表示bob出手
        // dp[i][j]表示由player i出手条件下，对于数字j，alice的胜负情况，1为alice胜，-1为bob胜，0为未处理
        // dp元素初始化为0，表示还未处理
        int[] dp = new int[n + 1];
        dp[1] = -1;
        for (int i = 2; i <= n; i++) {
            int minDiv = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    minDiv = j;
                    break;
                }
            }
            dp[i] = -dp[i - minDiv];
        }
        if (dp[n] == 1) {
            return true;
        } else {
            return false;
        }
        // 暴力递归入口↓
        // return process(n, 1);
    }

    /*
     * @description:在player操作，黑板上数字为n时，游戏的结果(暴力递归)
     * 
     * @param n:当前黑板上的数字
     * 
     * @param player:当前操作的游戏者，1为alice，0为bob
     * 
     * @return:最后游戏的结果
     */
    public static boolean process(int n, int player) {
        if (n == 1 && player == 0) {
            return true;
        }
        if (n == 1 && player == 1) {
            return false;
        }
        int minDiv = 1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                minDiv = i;
                break;
            }
        }
        return process(n - minDiv, 1 - player);
    }
}
