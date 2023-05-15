package tencent;

import java.util.Scanner;

public class main03 {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] A = new int[len];
        int[] B = new int[len];
        for (int i = 0; i < len; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
            B[i] = sc.nextInt();
        }
        int[] C = new int[len];
        
    }

    public static int getAns(int[] a, int[] c) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - c[i]);
        }
        return sum;
    }
}
