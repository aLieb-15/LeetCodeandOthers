package clone;

import java.io.*;
import java.lang.*;

public class Person implements Cloneable, Serializable{
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    // 浅拷贝方法
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // 深拷贝方法
    public Person deepClone() throws IOException, ClassNotFoundException, NotSerializableException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (Person) oi.readObject();
    }
}
