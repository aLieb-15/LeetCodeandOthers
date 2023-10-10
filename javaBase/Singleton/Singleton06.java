package javaBase.Singleton;

/**
 * 枚举类实现（线程安全）
 * 天然防止反射和反序列化调用
 */
public enum Singleton06 {
    INSTANCE;

    public void doSomeThing() {

    }
}
