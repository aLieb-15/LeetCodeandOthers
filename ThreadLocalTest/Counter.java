package ThreadLocalTest;

public class Counter {
    private static ThreadLocal<Integer> threadLocalCount = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public void increase() {
        int count = threadLocalCount.get();
        threadLocalCount.set(count + 1);
        System.out.println("Thread " + Thread.currentThread().getId() + " count: " + threadLocalCount.get());
    }
}
