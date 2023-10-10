package javaBase.FactoryMethod;

import javaBase.SingleFactory.Animal;
import javaBase.SingleFactory.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
