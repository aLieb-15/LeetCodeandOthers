package javaBase.AbstractFactory;

public class Xiaomi implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("Xiaomi, qidong!");
    }

    @Override
    public void shutdown() {
        System.out.println("Xiaomi, guanji!");
    }

    @Override
    public void callup() {
        System.out.println("Xiaomi, callup!");
    }

    @Override
    public void sendMessage() {
        System.out.println("Xiaomi, sendMessage!");
    }
}
