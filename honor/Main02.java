package honor;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        double P_large = Double.parseDouble(s.substring(1));
        int N_meas = sc.nextInt();
        int N1 = sc.nextInt();
        s = sc.next();
        int N2 = Integer.parseInt(s.substring(0, s.length() - 1));

        double res = 0;
        for (int x = N1; x <= N2; x++) {
            res += bigC(x, N_meas) * Math.pow(P_large, x) * Math.pow((1-P_large), (N_meas-x));
        }
        System.out.println(String.format("%1.2f", res));
    }

    public static double bigC(int up, int low) {
        double sum1 = 1;
        double sum2 = 1;
        for (int i = 0; i < up; i++) {
            sum1 *= (low - i);
            sum2 *= (i + 1);
        }
        return sum1 / sum2;
    }
}
