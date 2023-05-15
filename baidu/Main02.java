package baidu;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (true) {
            int tmp = (i * (i + 1)) / 2;
            if (tmp >= x) {
                break;
            }
            i++;
        }
        i--;
        for (int j = 0; j < i; j++) {
            sb.append('r');
        }
        char[] cs = {'d', 'e', 'r'};
        int tmp = (i * (i + 1)) / 2;
        int dump = x - tmp;
        for (int m = 0; m < dump; m++) {
            sb.append(cs[m%3]);
        }
        System.out.println(sb.toString());
    }
}
