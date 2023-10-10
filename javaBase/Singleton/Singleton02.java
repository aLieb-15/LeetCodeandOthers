package javaBase.Singleton;

/**
 * 提前初始化好一个实例，不管是否需要使用，顺便避免了线程不安全的问题
 */
public class Singleton02 {
    private static Singleton02 uniqueInstance = new Singleton02();

    private Singleton02() {

    }

    public static Singleton02 getSingleton02() {
        return uniqueInstance;
    }
}
