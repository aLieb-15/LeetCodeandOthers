package ZJS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.substring(1, input.length() - 1);
        String[] inputNums = input.split(",");
        int a, b = 0, c;
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(inputNums[i]);
            if (tmp > max) {
                max = tmp;
            }
            if (tmp < min) {
                min = tmp;
            }
        }
        a = min;
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(inputNums[i]);
            if (tmp != min && tmp != max) {
                b = tmp;
            }
        }
        c = max;
        
        if (a == b || b == c || a == c) {
            System.out.println("false");
            return;
        }
        
        // 正三角形边长
        int len = c - b;
        int at = 0, bt = 0, ct = 0;
        int ai = 0, bi = 0, ci = 0;
        int i = 0;
        int count = 0;
        List<Integer> leftIndexList = new ArrayList<>();
        int[] leftIndex = new int[c / 2 + 2];
        int[] rightIndex = new int[c / 2 + 2];
        leftIndexList.add(-1);
        while(count != 3) {
            int left = i * (i + 1) / 2 + 1;
            i++;
            int right = i * (i + 1) / 2;
            leftIndex[i] = left;
            leftIndexList.add(left);
            System.out.println("tair:" + i + " left: " + left + " right: " + right);
            if (a >= left && a <= right) {
                at = i;
                ai = a - left;
                count++;
            } 
            if (b >= left && b <= right) {
                bt = i;
                bi = b - left;
                count++;
            } 
            if (c >= left && c <= right) {
                ct = i;
                ci = c - left;
                count++;
            } 
        }
        int ab = b, ac = c;
        ab = leftIndexList.indexOf(bt - len) + bi;
        // ab = leftIndex[bt - len] + bi;
        // ac = leftIndex[ct - len] + ci - len;
        ac = leftIndexList.indexOf(ct - len) + ci - len;
        System.out.println("ab: " + ab);
        System.out.println("ac: " + ac);
        if (ab == ac) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // System.out.println(at + " " + bt + " " + ct);
        // System.out.println(ai + " " + bi + " " + ci);
        // System.out.println("true");
    }
}
