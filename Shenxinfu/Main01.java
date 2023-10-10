package Shenxinfu;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        String[] tempA = strA.split(" ");
        String[] tempB = strB.split(" ");
        int[] numA = new int[tempA.length];
        int[] numB = new int[tempB.length];
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < tempA.length; i++) {
            numA[i] = Integer.valueOf(tempA[i]);
            sumA += numA[i];
        }
        for (int i = 0; i < tempB.length; i++) {
            numB[i] = Integer.valueOf(tempB[i]);
            sumB += numB[i];
        }
        int gap = sumA - sumB;
        if (gap % 2 != 0 || gap == 0) {
            System.out.println("fail");
            return;
        }
        for (int i = 0; i < numA.length; i++) {
            for (int j = 0; j < numB.length; j++) {
                if (numA[i] - numB[j] == gap / 2) {
                    System.out.println(numA[i] + " " + numB[j]);
                    return;
                }
            }
        }
        System.out.println("fail");
    }
}
