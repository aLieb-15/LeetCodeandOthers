import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LeetCode12 {
    public static void main(String[] args) {

    }

    /**
     * 
     * @param board 二维字符矩阵
     * @param word  要找的单词
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param board 二位字符矩阵
     * @param words String word转成的char数组
     * @param i     当前的行坐标
     * @param j     当前的列坐标
     * @param k     当前要找的字母在字符数组中的索引
     * @return
     */
    public static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 行或列索引越界，返回false
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        // 当前字符和要找的字符不匹配，返回false
        // 当前字符已经被访问过，返回false
        if (words[k] != board[i][j]) {
            return false;
        }
        // 到这里为止，字符是必定匹配的
        // 若已经到达目标字符串的最后一位，返回true
        if (k == words.length - 1) {
            return true;
        }

        // 将访问过的字符标记
        board[i][j] = '\0';

        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;

    }
}
