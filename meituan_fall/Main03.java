package meituan_fall;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long max = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>((x, y) -> (int)(y - x));
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
            queue.add(arr[i]);
        }

        long start = arr[0];
        long ops = 0;
        while (start < max) {
            start *= 2;
            ops++;
        }
        start = arr[0];
        int cnt = 0;
        while (start < queue.peek()) {
            start *= 2;
            cnt++;
            if (start < queue.peek()) {
                Long poll = queue.poll();
                poll /= 2;
                queue.add(poll);
                cnt++;
            }
        }
        System.out.println(Math.min(ops, cnt));
    }
}
