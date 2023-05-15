import java.util.List;
import java.util.Map;

import javax.sound.sampled.SourceDataLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1125 {
    private static int[] mask;
    private static long all;
    private static long[][] memo;

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> sid = new HashMap<>();

        // 将所有的技能以<skill, index>的格式存储
        int m = req_skills.length;
        for (int i = 0; i < m; i++) {
            sid.put(req_skills[i], i);
        }

        // 初始化每个人的技能序列，使用1左移求与的方式记录
        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : people.get(i)) {
                mask[i] |= 1 << sid.get(s);
            }
        }

        int u = 1 << m;
        memo = new long[n][u];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        all = (1L << n) - 1;
        long res = dfs(n-1, u-1);

        System.out.println("res:" + res);
        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < n; i++) {
            if (((res >> i) & 1) > 0) {
                ans[j++] = i;
            }
        }
        return ans;
    }

    public static long dfs(int i, int j) {
        printIntArray(memo);
        if (j == 0) {
            return 0;
        }
        if (i < 0) {
            return all;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        long res = dfs(i-1, j);
        long res2 = dfs(i-1, j &~mask[i]) | (1L << i);
        return memo[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
    }

    private static <T> void printArray(T[][] input) {
        for (T[] t : input) {
            for (T tt : t) {
                System.out.print(tt + " ");
            }
            System.out.println();
        }
    }

    private static void printIntArray(long[][] input) {
        for (long[] row : input) {
            for (long e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String[] reqSkills = {"java","nodejs","reactjs"};
        List<String> l1 = new ArrayList<>();
        l1.add("java");
        List<String> l2 = new ArrayList<>();
        l2.add("nodejs");
        List<String> l3 = new ArrayList<>();
        l3.add("nodejs");
        l3.add("reactjs");
        List<List<String>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        System.out.println(smallestSufficientTeam(reqSkills, ll));
    }
}
