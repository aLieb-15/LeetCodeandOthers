package javaBase.Singleton;

/**
 * 懒汉式，线程安全写法
 */
public class Singleton03 {
    private static Singleton03 uniqueInstance;

    private  Singleton03() {

    }

    /*
     * 在get方法上加锁，可能多个线程同时进入到get方法体，导致线程阻塞
     */
    private static synchronized Singleton03 getSingleton03() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton03();
        }

        return uniqueInstance;
    }
}
