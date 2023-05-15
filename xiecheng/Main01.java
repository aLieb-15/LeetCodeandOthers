package xiecheng;

import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count = 0;
        char[][] gound = new char[x][y];
        for (int i = 0; i < x; i++) {
            gound[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                boolean hasY = false;
                boolean hasO = false;
                boolean hasU = false;
                if (i == x-1 || j == y-1) {
                    continue;
                }
                if (gound[i][j] == 'y' || gound[i+1][j] == 'y' || gound[i+1][j+1] == 'y' || gound[i][j+1] == 'y') {
                    hasY = true;
                }
                if (gound[i][j] == 'o' || gound[i+1][j] == 'o' || gound[i+1][j+1] == 'o' || gound[i][j+1] == 'o') {
                    hasO = true;
                }
                if (gound[i][j] == 'u' || gound[i+1][j] == 'u' || gound[i+1][j+1] == 'u' || gound[i][j+1] == 'u') {
                    hasU = true;
                }
                if (hasY && hasO && hasU) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
