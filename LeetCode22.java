import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        
        List<String> l = generateParenthesis(3);
        for (String s : l) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("()");
            return result;
        }

        dfs(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    public static void dfs(int n, List<String> result, StringBuilder track, int leftCount, int rightCount) {
        if (track.length() == n * 2) {
            result.add(track.toString());
            return ;
        }

        // 若最后合法，则left必定为n个，leftCount小于n时可以再添加一个
        if (leftCount < n) {
            track.append("(");
            dfs(n, result, track, leftCount + 1, rightCount);
            track.deleteCharAt(track.length() - 1);
        }

        if (rightCount < leftCount) {
            track.append(")");
            dfs(n, result, track, leftCount, rightCount + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
