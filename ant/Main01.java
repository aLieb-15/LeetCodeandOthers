package ant;

import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 65536; i++) {
            String hex = String.format("%04x", i);
            if (goodNum(hex)) {
                count++;
                if (count == k) {
                    System.out.println(hex);
                }
            }
        }
    }

    public static boolean goodNum(String hex) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < hex.length(); i++) {
            char c = Character.toLowerCase(hex.charAt(i));
            if (charSet.contains(c)) {
                return false;
            }
            charSet.add(c);
        }
        return true;
    }
}
