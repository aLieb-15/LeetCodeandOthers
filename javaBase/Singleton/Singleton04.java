package javaBase.Singleton;

/**
 * 双重检查锁实现
 * 改进线程安全的懒汉式
 * 将锁粒度变小，并且多加一个检查
 * 这种实现里，只有第一次实例化的时候会出现线程阻塞的情况，后续不会出现线程阻塞
 * 03的实现只要进方法就会出现阻塞，这个是只有已经发现实例没初始化的时候才会进入阻塞
 * 并且为了防止出现多次初始化，还要多加一个判断
 */
public class Singleton04 {
    // 为什么用volatile
    // 防止多线程场景下，由于JVM的指令重排
    // 有线程取到还没初始化完毕的实例
    private volatile static Singleton04 uniqueInstance;

    private Singleton04() {

    }

    public static Singleton04 getSingleton04() {
        if (uniqueInstance == null) {
            synchronized (Singleton04.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton04();
                }
            }
        }
        return uniqueInstance;
    }
}
