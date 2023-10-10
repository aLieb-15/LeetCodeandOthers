package JDFall;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        double r1, r2;
        // r^2 - 2(x + y)r + (x^2 + y^2) = 0
        double a = 1.0;
        double b = 2 * (x + y);
        double c = Math.pow(x, 2.0) + Math.pow(y, 2.0);

        double disc = b * b - 4 * a * c;
        double p = 0 - (b / 2 * a);
        double q = Math.sqrt(disc) / (2 * a);
        r1 = Math.abs(p + q);
        r2 = Math.abs(p - q);
        System.out.println(r1 + " " + r2);
    }
}
