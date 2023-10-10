package JUC;

import java.util.concurrent.CountDownLatch;

public class PrintTest {
    public static void main(String[] args) {
        String numberA = "123456";
        String characterB = "abcedf";

        Object lock = new Object();
        CountDownLatch latch = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            synchronized(lock) {
                for (char c : numberA.toCharArray()) {
                    System.out.println(c);
                    try {
                        System.out.println("latch: " + latch.getCount());
                        latch.countDown();
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                for (char c : characterB.toCharArray()) {
                    try {
                        System.out.println(c);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        
        threadA.start();
        threadB.start();
    }
}
