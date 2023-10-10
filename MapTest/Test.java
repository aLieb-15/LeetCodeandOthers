package MapTest;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3, 4);
        for (int i : map.keySet()) {
            if (i == 1) {
                map.remove(i);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                map.remove(i);
            }
        }
        System.out.println(map.hashCode());
        System.out.println(System.identityHashCode(map));
        System.out.println(map.hashCode());

        
    }
}
