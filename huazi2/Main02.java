package huazi2;

import java.util.*;

public class Main02 {
    static String ans = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.split("\\+");
        if (ss[0].indexOf(".") > 0 && ss[1].indexOf(".") > 0) {
            String[] ss1 = ss[0].split("\\.");
            String[] ss2 = ss[1].split("\\.");
            int t = 0; 
            if (ss1[1].length() < ss2[1].length()) {
                t = add1(ss1[1], ss2[1]);
            } else {
                t = add1(ss2[1], ss1[1]);
            }
            ans = "." + ans;
            add2(ss1[0], ss2[0], t);
        } else if (ss[0].indexOf(".") >= 0) {
            String[] ss1 = ss[0].split("\\.");
            int t = add1("", ss1[1]);
            ans = "." + ans;
            add2(ss1[0], ss[1], t);
        } else if (ss[1].indexOf(".") >= 0) {
            String[] ss2 = ss[1].split("\\.");
            int t = add1("", ss2[1]);
            ans = "." + ans;
            add2(ss2[0], ss[0], t);
        } else {
            add2(ss[0], ss[1], 0);
        }
        int k = ans.length() - 1;
        while (ans.charAt(k) == '0') {
            k--;
        }
        if (ans.charAt(k) == '.') {
            k--;
        }
        ans = ans.substring(0, k + 1);
        System.out.println(ans);
    }

    public static int add1(String a, String b) {
        int n = a.length();
        StringBuilder sb = new StringBuilder();
        sb.append(b.substring(n));
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 == '!' && c2 == '!') {
                sb.append((cnt));
                cnt = 2;
            } else if ((c1 == '!' && c2 == '@') || (c2 == '!' && c1 == '@')) {
                sb.append((13 + cnt) % 10);
                cnt = (13 + cnt) / 10;
            } else if ((c1 == '!' && c2 == '#') || (c2 == '!' && c1 == '#')) {
                sb.append((4 + cnt) % 10);
                cnt = (4 + cnt) / 10;
            } else if (c1 == '@' && c2 == '@') {
                sb.append((7 + cnt) % 10);
                cnt = (7 + cnt) / 10;
            } else if ((c1 == '@' && c2 == '#') || (c2 == '@' && c1 == '#')) {
                sb.append((20 + cnt) % 10);
                cnt = (20 + cnt) / 10;
                // sb.append(cnt);
                // cnt = 2;
            } else if (c1 == '#' && c2 == '#') {
                sb.append((5 + cnt) % 10);
                cnt = (5 + cnt) / 10;
            } else {
                int sum = (c1 - '0') + (c2 - '0') + cnt;
                sb.append(sum % 10);
                cnt = sum / 10;
            }
        }
        ans = sb.reverse().toString();
        return cnt;
    }

    public static void add2(String a, String b, int t) {
        int n = a.length();
        int m = b.length();
        int cnt = t;
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();
        while (i >=0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            if (c1 == '!' && c2 == '!') {
                sb.append(cnt);
                cnt = 2;
            } else if ((c1 == '!' && c2 == '@') || (c2 == '!' && c1 == '@')) {
                sb.append((13 + cnt) % 10);
                cnt = (13 + cnt) / 10;
            } else if ((c1 == '!' && c2 == '#') || (c2 == '!' && c1 == '#')) {
                sb.append((4 + cnt) % 10);
                cnt = (4 + cnt) / 10;
            } else if (c1 == '@' && c2 == '@') {
                sb.append((7 + cnt) % 10);
                cnt = (7 + cnt) / 10;
            } else if ((c1 == '@' && c2 == '#') || (c2 == '@' && c1 == '#')) {
                sb.append((20 + cnt) % 10);
                cnt = (20 + cnt) / 10;
                // sb.append(cnt);
                // cnt = 2;
            } else if (c1 == '#' && c2 == '#') {
                sb.append((5 + cnt) % 10);
                cnt = (5 + cnt) / 10;
            } else {
                int sum = (c1 - '0') + (c2 - '0') + cnt;
                sb.append(sum % 10);
                cnt = sum / 10;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            char c = a.charAt(i);
            int sum = cnt + (c - '0');
            sb.append(sum % 10);
            cnt = sum / 10;
            i--;
        }
        while (j >= 0) {
            char c = b.charAt(j);
            int sum = cnt + (c - '0');
            sb.append(sum % 10);
            cnt = sum / 10;
            j--;
        }
        if (cnt != 0) {
            sb.append(cnt);
        }
        ans = sb.reverse().toString() + ans;
    }
}
