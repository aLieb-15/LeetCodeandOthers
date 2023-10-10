package ThreadTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int queueCapacity = 100;
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(queueCapacity);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 100L, TimeUnit.SECONDS, queue);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1, now there is :" + threadPool.getActiveCount() + " threads running");
                try {
                    Thread.sleep(10L);
                } catch (Exception e) {
                    // TODO: handle exception
                    Thread.currentThread().interrupt();
                }
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2, now there is :" + threadPool.getActiveCount() + " threads running");
            }
        }, null);

        System.out.println(threadPool.getActiveCount());
        // if (threadPool.getActiveCount() <= 2) {
        //     threadPool.shutdownNow();
        // }
        threadPool.shutdown();
    }
}
