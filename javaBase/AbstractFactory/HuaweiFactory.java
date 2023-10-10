package javaBase.AbstractFactory;

public class HuaweiFactory implements ProductFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new Huawei();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
