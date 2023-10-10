package clone;

import java.io.*;
import java.lang.*;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
        Address address = new Address("Beijing", 100000);
        Person person1 = new Person("Tom", address);

        // 浅拷贝
        Person person2 = person1.shallowClone();
        System.out.println(person1.getAddress() == person2.getAddress()); // true
        System.out.println(person1.getAddress().hashCode() == person2.getAddress().hashCode()); // true

        // 深拷贝
        Person person3 = person1.deepClone();
        System.out.println(person1.getAddress() == person3.getAddress()); // false
        System.out.println(person1.getAddress().hashCode() == person3.getAddress().hashCode()); // false
    }
}
