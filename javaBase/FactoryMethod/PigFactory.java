package javaBase.FactoryMethod;

import javaBase.SingleFactory.Animal;
import javaBase.SingleFactory.Pig;

public class PigFactory implements AnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Pig();
    }
}
