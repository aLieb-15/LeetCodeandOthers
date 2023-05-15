import java.util.HashMap;
import java.util.Map;

public class LeetCodeOffer48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int l = 0;
        int r = 1;
        int maxLen = 1;
        // Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        // set.add(s.charAt(l));
        map.put(s.charAt(l), l);
        
        while (r < len) {
            if (map.containsKey(s.charAt(r))) {
                int where = map.get(s.charAt(r));
                map.remove(s.charAt(l));
                if (map.containsKey(s.charAt(r))) {
                    map.remove(s.charAt(r));
                }
                l = ++where;
            }
            map.put(s.charAt(r), r);
            // set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            System.out.print(l);
            System.out.print(r);
            System.out.println();
            r++;
        }
        return maxLen;
    }
}
