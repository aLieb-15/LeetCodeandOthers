package ant;

import java.util.*;

public class Main03plus {
    public static Map<String, Integer> map;
    public static int MOD = 1000000007;

    public static void main(String[] args) {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(dfs(s, 0, new StringBuilder()) % MOD);
    }

    public static int dfs(String s, int cur, StringBuilder sb) {
        String key = cur + "_" + sb;
        if (cur == s.length()) {
            if (sb.length() == 0) {
                return 0;
            }

            return check(sb.toString()) ? 1 : 0; 
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = dfs(s, cur + 1, sb);
        sb.append(s.charAt(cur));
        ans += dfs(s, cur + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        map.put(key, ans);
        return ans;
    }

    public static boolean check(String s) {
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
