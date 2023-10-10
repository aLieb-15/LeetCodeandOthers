package BigSpeakDesignModel.DecoratorModel;

public class ConcreteDecotatorB extends Decorator{
    @Override
    public void Operation() {
        super.Operation();
        AddedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void AddedBehavior() {
        System.out.println("具体装饰对象B的独有行为");
    }
}
