package xiecheng;

import java.util.Scanner;

public class Main02 {
    public static Long gbs(Long a, Long b) {
        Long g = 0L;
        Long m = a;
        Long n = b;
        Long fan = 0L;
        while (m % n != 0) {
            fan = m % n;
            m = n;
            n = fan;
        }
        return a * b / n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            Long tmp = Long.parseLong(sc.next());
            if (tmp % 2 == 1) {
                Long a = tmp / 2;
                Long b = a + 1;
                System.out.println(a + " " + b);
            } else {
                Long index = tmp / 2;
                Long a = index - 1;
                Long b = index + 1;
                Long j = gbs(a, b);
                if (index < j) {
                    System.out.println(a + " " + b);
                } else {
                    System.out.println(index + " " + index);
                }
            }
        }
        sc.close();
    }
}
