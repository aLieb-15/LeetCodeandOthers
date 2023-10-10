package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintCharThree {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread threadA = new Thread(new SyncNumberPrinter(lock, conditionA, conditionB));
        Thread threadB = new Thread(new SyncNumberPrinter(lock, conditionB, conditionC));
        Thread threadC = new Thread(new SyncNumberPrinter(lock, conditionC, conditionA));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class SyncNumberPrinter implements Runnable {
    private static volatile int num = 0;

    private final int PRINT_TIMES = 1000;

    private final ReentrantLock reentrantLock;

    private final Condition currentCondition;

    private final Condition nextCondition;

    public SyncNumberPrinter(ReentrantLock reentrantLock, Condition currentCondition, Condition nextCondition) {
        this.reentrantLock = reentrantLock;
        this.currentCondition = currentCondition;
        this.nextCondition = nextCondition;
    }

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < PRINT_TIMES; i++) {
                System.out.println(Thread.currentThread().getName() + " print: " + num);
                num++;
                // Thread.sleep(1000);
                nextCondition.signalAll();
                if (i < PRINT_TIMES - 1) {
                    currentCondition.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
