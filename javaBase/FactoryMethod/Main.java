package javaBase.FactoryMethod;

import javaBase.SingleFactory.Animal;

public class Main {
    public static void main(String[] args) {
        Animal dog = new DogFactory().getAnimal();
        Animal pig = new PigFactory().getAnimal();

        dog.animal();
        pig.animal();
    }
}
