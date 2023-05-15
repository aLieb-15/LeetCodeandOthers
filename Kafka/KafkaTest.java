package Kafka;

import java.util.Properties;

import com.oracle.webservices.internal.api.message.PropertySet;

public class KafkaTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(001, "张三");
        props.put(002, "李四");
        System.out.println(props.toString());
    }

    public static void test() {
        
    }
}
