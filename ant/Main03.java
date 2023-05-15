package ant;

import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        int[] count = new int[26];
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(dfs(s, "", count, -1)-1);
    }

    public static int dfs(String s, String sub, int[] count, int index) {
        int res = 0;
        if (goodSubString(sub)) {
            System.out.println(sub);
            res++;
        }
        if (sub.length() == s.length()) {
            return res;
        }
        for (int i = index + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            count[i]++;
            res += dfs(s, sub + c, count, i);
            count[i]--;
        }
        return res;
    }

    public static boolean goodSubString(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
