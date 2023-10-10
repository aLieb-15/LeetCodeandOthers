package javaBase.AbstractFactory;

public class Huawei implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("Yaoyaolingxian!");
    }

    @Override
    public void shutdown() {
        System.out.println("Yongbuguanji!");
    }

    @Override
    public void callup() {
        System.out.println("Huaweilaidian!");
    }

    @Override
    public void sendMessage() {
        System.out.println("ZhanlangMessage!");
    }
}
