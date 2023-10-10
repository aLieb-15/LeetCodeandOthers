package meituan_fall;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n - 1];
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            a[i] = num;
            if (i != 0) {
                b[i - 1] = a[i] - a[i - 1]; 
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (a[i] <= a[i - 1]) {
                System.out.println("No");
                return;
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (b[i] <= b[i + 1]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
