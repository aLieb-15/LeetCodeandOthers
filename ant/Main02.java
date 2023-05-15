package ant;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lowest = new int[n];
        int[] highest = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String num = sc.next();
            if (num.contains("?")) {
                String h = num.replace("?", "9");
                String l = num.replace("?", "0");
                highest[i] = Integer.parseInt(h);
                lowest[i] = Integer.parseInt(l);
                count++;
            } else {
                highest[i] = Integer.parseInt(num);
                lowest[i] = Integer.parseInt(num);
            }
            if (highest[i] > max) {
                max = highest[i];
            }
            if (lowest[i] < min) {
                min = lowest[i];
            }
        }
        System.out.println(max - min);
    }
}
