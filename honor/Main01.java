package honor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main01 {
    public static int parseInt(List<Integer> list, boolean sign) {
        int x = 0;
        int len = list.size();
        int index = len - 1;
        int up = 1;
        while (index >= 0) {
            x += list.get(index) * up;
            if (x < 0) {
                if (sign) {
                    return Integer.MAX_VALUE;
                } else {
                    return 0 - Integer.MIN_VALUE;
                }
            }
            index--;
            up *= 10;
        }
        return x;
    }

    public static void main(String[] args) {
        // 2147483647
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chs = s.toCharArray();
        int i = 0;
        while (i < chs.length && chs[i] == ' ') {
            i++;
        }
        boolean pre = true;
        if (chs[i] != '-' && chs[i] != '+' && (chs[i] < '0' || chs[i] > '9')) {
            System.out.println(0);
            return;
        } 
        if (chs[i] == '-') {
            pre = false;
            i++;
        }
        
        List<Integer> list = new ArrayList<>();
        while (i < chs.length) {
            if (chs[i] < '0' || chs[i] > '9') {
                break;
            }
            list.add(chs[i] - '0');
            i++;
        }
        int result = parseInt(list, pre);

        if (!pre && result != Integer.MIN_VALUE) {
            System.out.print("-");
        }
        System.out.print(result);
    }
}
