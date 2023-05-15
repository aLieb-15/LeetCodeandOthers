package MultiThread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

class Thread2 extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(1);
        }
        System.out.println("Thread end");
    }

}

public class MultiThread {
    private volatile static MultiThread uniqueInstance;
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static MultiThread getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (MultiThread.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new MultiThread();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Thread thread2 = new Thread2();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    // public static void main(String[] args) {
    //     new Thread(() -> {
    //         synchronized (resource1) {
    //             System.out.println(Thread.currentThread() + "get resource1");
    //             try {
    //                 Thread.sleep(1000);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //             System.out.println(Thread.currentThread() + "waiting get resource2");
    //             synchronized (resource2) {
    //                 System.out.println(Thread.currentThread() + "get resource2");
    //             }
    //         }
    //     }, "线程 1").start();

    //     new Thread(() -> {
    //         synchronized (resource1) {
    //             System.out.println(Thread.currentThread() + "get resource2");
    //             try {
    //                 Thread.sleep(1000);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //             System.out.println(Thread.currentThread() + "waiting get resource1");
    //             synchronized (resource2) {
    //                 System.out.println(Thread.currentThread() + "get resource1");
    //             }
    //         }
    //     }, "线程 2").start();
    // }
}
