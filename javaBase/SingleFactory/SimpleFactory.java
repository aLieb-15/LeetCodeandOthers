package javaBase.SingleFactory;

public class SimpleFactory {
    public static Animal getFactory(String animal) {
        if (animal.equals("dog")) {
            return new Dog();
        } else if (animal.equals("pig")) {
            return new Pig();
        } else {
            return null;
        }
    }
}
