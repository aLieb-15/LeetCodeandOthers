package clone;

import java.io.*;
import java.lang.*;

public class Address implements Serializable{
    private String city;
    private int zipcode;

    public Address(String city, int zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }
}
