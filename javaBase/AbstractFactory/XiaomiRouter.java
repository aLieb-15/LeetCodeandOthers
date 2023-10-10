package javaBase.AbstractFactory;

public class XiaomiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("Xiaomi Router!");
    }

    @Override
    public void shutdown() {
        System.out.println("Xiaomi 886");
    }

    @Override
    public void callOpenWifi() {
        System.out.println("Xiaomi Open Wifi!");
    }
}
