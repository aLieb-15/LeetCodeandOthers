package SetTest;

import java.util.*;

public class Test {
    public static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        int len = list.size();
        // java.lang.IndexOutOfBoundsException
        // for (int i = 0; i < len; i++) {
        //     list.remove(i);
        // }

        // success
        // for (int i = len - 1; i >= 0; i--) {
        //     list.remove(i);
        // }
        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     iterator.next();
        //     iterator.remove();
        // }
        // System.out.println(list.size());
        System.out.println(tableSizeFor(13));
    }

    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
