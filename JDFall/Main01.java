package JDFall;

import java.util.Scanner;

public class Main01 {
    private static String selfString = "ilmnouvwx";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            isZhouduichen(s);
        }
    }

    public static void isZhouduichen(String s) {
        int len = s.length();
        if (len == 1) {
            if (selfString.contains(s.subSequence(0, 1))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            return;
        }
        int l = 0, r = len - 1;
        while (l < r) {
            if ((s.charAt(l) == 'p' && s.charAt(r) == 'q')
                    || (s.charAt(l) == 'q' && s.charAt(r) == 'p')
                    || (s.charAt(l) == 'b' && s.charAt(r) == 'd')
                    || (s.charAt(l) == 'd' && s.charAt(r) == 'b')) {
                l++;
                r--;
            } else if ((s.charAt(l) == s.charAt(r))
                    && selfString.contains(s.subSequence(l, l + 1))
                    && selfString.contains(s.subSequence(r, r + 1))) {
                l++;
                r--;
            } else {
                System.out.println("No");
                return;
            }
        }
        if (l == r && !selfString.contains(s.subSequence(l, l + 1))) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }
}
