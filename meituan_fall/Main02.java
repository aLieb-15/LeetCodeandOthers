package meituan_fall;
import java.util.Scanner;

public class Main02 {
    private static final String[] TARGET = {"m", "e", "i", "t", "u", "a", "n"};

    private static final int LEN = 6;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 7) {
            // 小于7行必定凑不出
            System.out.println("No");
            return;
        }
        int m = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        if (dfs(0, 0, strs)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean dfs(int index, int query, String[] arrs) {
        if (query == arrs.length) {
            return false;
        }
        if (index == LEN && arrs[query].contains(TARGET[index])) {
            return true;
        }
        if (arrs[query].contains(TARGET[index])) {
            return dfs(index + 1, query + 1, arrs);
        } else {
            return dfs(index, query + 1, arrs);
        }
    }
}
