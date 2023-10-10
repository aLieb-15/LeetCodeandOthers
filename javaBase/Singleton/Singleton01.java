package javaBase.Singleton;

/**
 * 懒汉式实现，第一次被调用时，再创建实例
 */
public class Singleton01 {
    private static Singleton01 singleton01;

    private Singleton01() {

    }

    public static Singleton01 getSingleton01() {
        return singleton01;
    }
}
