package ZJS;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numA = sc.nextLine();
        String numB = sc.nextLine();
        BigDecimal numAD = new BigDecimal(numA);
        BigDecimal numBD = new BigDecimal(numB);
        BigDecimal result = numAD.multiply(numBD);
        System.out.println(result.toString());
    }
}
