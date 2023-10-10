package javaBase.Singleton;

/**
 * 静态内部类实现，线程安全
 * 外部类被加载时，静态内部类不会被加载进内幕才能
 * 调用get方法时，才会将静态内部类加载进内存，并初始化INSTANCE实例
 * 并且JVM会确保INSYANCE只会被实例化一次
 */
public class Singleton05 {
    private Singleton05() {

    }

    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getSingleton05() {
        return SingletonHolder.INSTANCE;
    }
}
