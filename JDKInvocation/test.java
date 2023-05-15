package JDKInvocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class test {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        for (int i : map.keySet()) {
            if (i == 3) {
                map.remove(i);
            }
        }
        // SmsService service = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        // service.send("hhh");
        // System.out.println(tableSizeFor(70));
        // Set<Integer> set = new HashSet<>();
        // set.add(10);
        // System.out.println(set.size());
        // set.add(10);
        // System.out.println(set.add(101));

        // System.out.println(10&11);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n + " " + (n >>> 1));
        n |= n >>> 1;
        System.out.println(n + " " + (n >>> 2));
        n |= n >>> 2;
        System.out.println(n + " " + (n >>> 4));
        n |= n >>> 4;
        System.out.println(n + " " + (n >>> 8));
        n |= n >>> 8;
        System.out.println(n + " " + (n >>> 16));
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
