package javaBase.AbstractFactory;

public class XiaomiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new Xiaomi();
    }

    @Override
    public RouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
