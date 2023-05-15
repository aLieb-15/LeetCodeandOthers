import java.util.HashMap;
import java.util.Map;

public class TryingHashMap {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('a', 1);
        map.put('a', 2);
        System.out.println("a in map:" + map.get('a'));
        map.put('b', 3);
        map.remove('a');
        System.out.println(map.containsKey('a'));
        int i = map.get('b');
        System.out.println(i);
    }
}
