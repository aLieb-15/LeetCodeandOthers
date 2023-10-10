package ThreadTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
        //         100L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));
        // Future<String> future = threadPoolExecutor.submit(() -> {
        //     System.out.println("hello");
        //     Thread.sleep(5000);
        //     return "finished";
        // });
        // String result = future.get();
        // System.out.println(result);
        // threadPoolExecutor.shutdown();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "hello";
        });

        completableFuture.thenAccept(result -> System.out.println(result));

        completableFuture.join();
        
    }
}
