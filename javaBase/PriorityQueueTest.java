package javaBase;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer a, Integer b) -> {
            return b - a;
        });
        queue.add(1);
        queue.add(1000);
        queue.add(9999);
        System.out.println(queue.poll());
    }
}
