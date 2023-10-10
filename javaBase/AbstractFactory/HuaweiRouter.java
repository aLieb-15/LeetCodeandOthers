package javaBase.AbstractFactory;

public class HuaweiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("Yaoyaolingxian Router!");
    }

    @Override
    public void shutdown() {
        System.out.println("Huawei guanji!");
    }

    @Override
    public void callOpenWifi() {
        System.out.println("Huawei 5G!");
    }
}
