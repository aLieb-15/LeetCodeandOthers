package ByteDance;

import java.util.Map;
import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        Map<Double, Integer> map = new HashMap<>();
        map.put(-0.0, 1);
        map.put(1.0/Math.pow(2.0, 53.0), 1111);
        System.out.println(map.get(1.0/(Math.pow(2.0, 53.0) + 1)));

        Map<Long, Integer> map2 = new HashMap<>();

        System.out.println(0 == -0);
        System.out.println(new Integer(0).hashCode() == new Integer(-0).hashCode());
    }
}
