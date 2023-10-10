package javaBase.SingleFactory;

public class Main {
    public static void main(String[] args) {
        Animal dog = SimpleFactory.getFactory("dog");
        Animal pig = SimpleFactory.getFactory("pig");

        dog.animal();
        pig.animal();
    }
}
