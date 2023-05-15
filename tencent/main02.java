package tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// AC 纯纯天才
public class main02 {
    public static int count;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        count = 0;
        Set<String> ans = new HashSet<>();
        Set<Character> set = new HashSet<>();
        dfs(0, strs, set, ans);
        System.out.println(count);
    }
    public static void dfs(int index, String[] strs, Set<Character> set, Set<String> ans) {
        if (index == strs.length) {
            String tmp = sb.toString();
            if (!ans.contains(tmp)) {
                count++;
                ans.add(tmp);
            }
            return ;
        }
        char[] chars = strs[index].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                sb.append(chars[i]);
                dfs(index + 1, strs, set, ans);
                set.remove(chars[i]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
