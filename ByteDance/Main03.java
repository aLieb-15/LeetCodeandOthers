package ByteDance;

import java.util.HashMap;
import java.util.Map;

public class Main03 {
    public static void main(String[] args) {
        Map<Double, Integer> map = new HashMap<>();
        map.put(3.0/9, 1);
        map.put(6.0/18, 2);
        // System.out.println(map.keySet().size());
        for (Double d : map.keySet()) {
            System.out.println(d + " " + map.get(d));
        }
    }
}
