package honor;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] ss = s.split(",");
        int L = sc.nextInt();
        int len = ss.length;
        for (int i = 0; i < len; i++) {
            int cur = 0;
            int j = i;
            StringBuilder sb = new StringBuilder();
            while (j < len && cur + ss[j].length() + 1 <= L) {
                cur += (ss[j].length() + 1);
                j++;
            } 
            int cnt = j - i;
            if (cnt == 1) {
                sb.append(ss[i]);
                for (int k = 0; k < L - ss[i].length(); k++) {
                    sb.append("*");
                }
                System.out.println(sb.toString());
            } else if (j != len) {
                cur -= cnt;
                int num = L - cur;
                int avg = num / (cnt - 1);
                int sub = num % (cnt - 1);
                for (int k = i; k < j; k++) {
                    sb.append(ss[k]);
                    if (k != j - 1) {
                        for (int l = 0; l < avg + (sub > 0 ? 1 : 0); l++) {
                            sb.append("*");
                        }
                        sub--;
                    }
                }
                System.out.println(sb.toString());
            } else if (j == ss.length) {
                cur -= cnt;
                int num = L - cur;
                for (int k = i; k < j; k++) {
                    sb.append(ss[k]).append("*");
                    num--;
                }
                for (int k = 0; k < num; k++) {
                    sb.append("*");
                }
                System.out.println(sb.toString());
            }
            i = j;
        }   
    }
}
