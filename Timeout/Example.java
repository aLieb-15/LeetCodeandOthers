package Timeout;

import java.lang.reflect.Method;

public class Example {
    @TimeOut(5000)
    public void longRunningMethod() {
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("successfully!");
    }

    public static void main(String[] args) {
        Example example = new Example();
        // Method method = example.getClass().getMethod("longRunningMethod");
    }
}
