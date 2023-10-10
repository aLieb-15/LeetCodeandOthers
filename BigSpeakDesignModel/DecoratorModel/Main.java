package BigSpeakDesignModel.DecoratorModel;

/**
 * 装饰模式（Decorator）动态地给一个对象添加一些额外的职责
 * 就新增功能来说，装饰模式比生成子类更加灵活
 */
public class Main {
    public static void main(String[] args) {
        // Person xc = new Person("jth");

        // xc.wearTShirt();
        // xc.wearBigTrouser();
        // xc.show();

        // xc.waerSneakers();
        // xc.show();

        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecotatorB d2 = new ConcreteDecotatorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.Operation();
        
    }
}
