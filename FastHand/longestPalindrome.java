package FastHand;

public class longestPalindrome {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
    }

    public static String longestPalindromeEnter(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }

        int maxLen = Integer.MIN_VALUE;
        int beginIndex = -1;

        char[] chs = s.toCharArray();

        // dp[i][j]：从i到j的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 所有长度为1的串全都是回文串
            dp[i][i] = true;
        }

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (chs[l] == chs[r] && ((r - l < 2) || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    int curLen = r - l + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        beginIndex = l;
                    }
                }
            }
        }

        return s.substring(beginIndex, beginIndex + maxLen - 1);
    }
}
