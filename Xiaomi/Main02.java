package Xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] ss = s.split(",");
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < ss.length; i++) {
            String tmp = ss[i];
            int p = Integer.valueOf(tmp.split(":")[0]);
            int q = Integer.valueOf(tmp.split(":")[1]);
            graph.get(p).add(q);
        }
        System.out.println(isValid(n, graph) ? "1" : "0");
    }

    public static boolean isValid(int n, List<List<Integer>> graph) {
        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            if (status[i] == 0) {
                if (!dfs(graph, status, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(List<List<Integer>> graph, int[] status, int curr) {
        status[curr] = 1;
        for (int next : graph.get(curr)) {
            if (status[next] == 1) {
                return false;
            } else if (status[next] == 0) {
                if (!dfs(graph, status, next)) {
                    return false;
                }
            }
        }
        status[curr] = 2;
        return true;
    }
}
