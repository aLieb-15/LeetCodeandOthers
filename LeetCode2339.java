import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode2339 {
    public static boolean checkDistances(String s, int[] distance) {
        Set<Character> record = new HashSet<>();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            record.add(c);
        }
        Iterator iterator = record.iterator();
        while (iterator.hasNext()) {
            char c = (char)iterator.next();
            int jump = distance[c - 'a'];
            int index = 0;
            for (; index < chs.length; index++) {
                if (chs[index] == c) {
                    break;
                }
            }
            if (index == chs.length) {
                continue;
            }
            int count = 2;
            while (index < chs.length) {
                if (chs[index] != c) {
                    return false;
                }
                index = index + jump + 1;
                count--;
                if (count == 0) {
                    break;
                }
            }
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // System.out.println(checkDistances(s, distance));
        System.out.println(1<<10);
        System.out.println(Long.bitCount(1023));
    }
}