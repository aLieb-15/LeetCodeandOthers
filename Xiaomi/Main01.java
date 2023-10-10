package Xiaomi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
    public static double getDistance(int x, int y, int i, int j) {
        int xGap = Math.abs(x - i);
        int yGap = Math.abs(y - j);
        return Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(s.split(",")[0]);
        int radius = Integer.valueOf(s.split(",")[1]);
        Map<int[], Integer> map = new HashMap<>();
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = -1;
        int yMax = -1;

        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            String[] ss = s.split(",");
            int x = Integer.valueOf(ss[0]);
            int y = Integer.valueOf(ss[1]);
            xMin = Math.min(x, xMin);
            yMin = Math.min(y, yMin);
            xMax = Math.max(x, xMax);
            yMax = Math.max(y, yMax);
            int q = Integer.valueOf(ss[2]);
            map.put(new int[]{x, y}, q);
        }

        int xResult = -1;
        int yResult = -1;
        int qResult = -1;
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                int sum = 0;
                for (int[] xy : map.keySet()) {
                    int x = xy[0];
                    int y = xy[1];
                    double distance = getDistance(x, y, i, j);
                    if (distance > radius) {
                        continue;
                    }
                    int temp = (int)Math.floor(map.get(xy) / (1 + distance));
                    sum += temp;
                }
                if (sum > qResult) {
                    qResult = sum;
                    xResult = i;
                    yResult = j;
                }
            }
        }
        System.out.println(xResult + "," + yResult);
    }
}
