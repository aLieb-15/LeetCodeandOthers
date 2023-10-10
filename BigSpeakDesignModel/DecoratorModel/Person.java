package BigSpeakDesignModel.DecoratorModel;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void wearTShirt() {
        System.out.println("穿T恤");
    }

    public void wearBigTrouser() {
        System.out.println("穿垮裤");
    }

    public void waerSneakers() {
        System.out.println("破球鞋");
    }

    public void show() {
        System.out.println("装扮的" + name);
    }
}
