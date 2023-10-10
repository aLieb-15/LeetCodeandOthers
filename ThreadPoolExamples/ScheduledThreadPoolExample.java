package ThreadPoolExamples;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用ScheduledThreadPool实现任务的
 *  等一段时间再执行
 *  重复执行
 * 配合Future实现任务超时结束并回滚
 */
public class ScheduledThreadPoolExample {
    private static int x;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // executor.schedule(() -> {
        //     System.out.println("Delayed task executed.");
        // }, 2, TimeUnit.SECONDS);

        // executor.scheduleAtFixedRate(() -> {
        //     System.out.println("Repeated task executed.");
        // }, 0, 3, TimeUnit.SECONDS);
        x = 100;

        Callable<String> task = () -> {
            System.out.println("Performing operation...");
            x = x + 100;
            System.out.println(x);
            Thread.sleep(3000);

            return "Operation completed successfilly.";
        };
        Future<String> future = executor.submit(task);

        try {
            String result = future.get(2, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (Exception e) {
            // TODO: handle exception
            // 回滚操作写在这
            e.printStackTrace();
            x = x - 100;
        }
        System.out.println(x);
        executor.shutdown();
    }
}
