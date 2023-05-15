package baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Set<Character> set0 = new HashSet<>();
        
        set0.add('B');
        set0.add('a');
        set0.add('i');
        set0.add('d');
        set0.add('u');
        for (int i = 0; i < t; i++) {
            Set<Character> set = new HashSet<>();
            String s = sc.next();
            System.out.println(s);
            if (s.length() < 5) {
                System.out.println("No");
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set0.contains(c)) {
                    continue;
                }
                if (!set.contains(c)) {
                    set.add(c);
                }
            }
            if (set.size() == 5) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
