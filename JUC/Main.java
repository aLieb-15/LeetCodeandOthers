package JUC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class OddPrint implements Runnable{
    private List<Integer> list = Arrays.asList(1,3,5,7,9);

    @Override
    public void run() {
        synchronized (Main.class) {
            for (int i = 0; i < list.size(); i++) {
                while (Main.getTurn() != 1) {
                    try {
                        Main.class.wait();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                System.out.println(list.get(i));
                Main.setTurn(2);
                Main.class.notify();
            }
        }
    }
}

class EvenPrint implements Runnable{
    private List<Integer> list = Arrays.asList(2,4,6,8,10);

    @Override
    public void run() {
        synchronized (Main.class) {
            for (int i = 0; i < list.size(); i++) {
                while (Main.getTurn() != 2) {
                    try {
                        Main.class.wait();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                System.out.println(list.get(i));
                Main.setTurn(1);
                Main.class.notify();
            }
        }
    }
}

public class Main {
    private static final Object lock = new Object();
    private static int turn = 1;

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int val) {
        turn = val;
    }

    public static void main(String[] args) throws InterruptedException {
        // Thread tA = new Thread(()->{
        //     List<Integer> list = Arrays.asList(1,3,5,7,9);
        //     synchronized (lock) {
        //         for (int i = 0; i < list.size(); i++) {
        //             while (turn != 1) {
        //                 try {
        //                     lock.wait();
        //                 } catch (Exception e) {
        //                     System.out.println(e.getMessage());
        //                 }
        //             }
        //             System.out.println(list.get(i));
        //             turn = 2;
        //             lock.notify();
        //         }
        //     }
        // });
        // Thread tB = new Thread(()->{
        //     List<Integer> list = Arrays.asList(2,4,6,8,10);
        //     synchronized (lock) {
        //         for (int i = 0; i < list.size(); i++) {
        //             while (turn != 2) {
        //                 try {
        //                     lock.wait();
        //                 } catch (Exception e) {
        //                     System.out.println(e.getMessage());
        //                 }
        //             }
        //             System.out.println(list.get(i));
        //             turn = 1;
        //             lock.notify();
        //         }
        //     }
        // });

        Thread tA = new Thread(new OddPrint());
        Thread tB = new Thread(new EvenPrint());
        Deque<Integer> q = new LinkedList<>();
        q.push(3);
        List<Integer> l = new ArrayList<>();
        

        tA.start();
        tB.start();
    }
}