package javaBase.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("========Xiaomi========");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        PhoneProduct xiaomiPhone = xiaomiFactory.phoneProduct();
        xiaomiPhone.start();
        xiaomiPhone.callup();

        System.out.println("========Huawei========");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        RouterProduct huaweiRouter = huaweiFactory.routerProduct();
        huaweiRouter.start();
        huaweiRouter.callOpenWifi();
    }
}
