package xiecheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import IO.read;

public class Main03 {
    static int[] weight;
    static int n;
    static long l, r;
    static long ans;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        String s = sc.next();
        weight = new int[n + 1];
        for (int i = 0; i < n; i++) {
            weight[i+1] = s.charAt(i) - '0';
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            List<Integer> l1 = map.getOrDefault(u, new ArrayList<>());
            List<Integer> l2 = map.getOrDefault(v, new ArrayList<>());
            l1.add(v);
            l2.add(u);
            map.put(u, l1);
            map.put(v, l2);
        }
        for (int i = 1; i <= n; i++) {
            dfs(i, 0L, 0, new boolean[n+1]);
        }
        System.out.println(ans);
    }

    public static void dfs(int i, long cur, int sum, boolean[] vis) {
        if (cur > r) {
            return;
        }
        cur = (cur << 1) | weight[i];
        if (cur >= l && cur <= r && sum > 0) {
            ans++;
        }
        List<Integer> l = map.getOrDefault(i, new ArrayList<>());
        vis[i] = true;
        for (int next : l) {
            if (!vis[next]) {
                dfs(next, cur, sum + 1, vis);
            }
        }
        vis[i] = false;
    }
}
