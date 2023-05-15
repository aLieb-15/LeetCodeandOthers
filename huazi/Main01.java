package huazi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int tmpCount = sc.nextInt();
            for (int j = 0; j < tmpCount; j++) {
                int tmp = sc.nextInt();
                graph[tmp].add(i);
                inDegree[i]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        int count = 0;
        int batchSize = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            int batchCount = 0;
            for (int i = 0; i < curSize; i++) {
                int curEle = queue.pollFirst();
                count++;
                batchCount++;
                for (int next : graph[curEle]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.addLast(next);
                    }
                }
            }
            if (batchCount != 0) {
                batchSize++;
            }
        }
        if (count != N) {
            System.out.println(-1);
        } else {
            System.out.println(batchSize);
        }
    }
}
