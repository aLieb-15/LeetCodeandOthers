package mihoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
    private static int cases = 0;
    private static int killCases = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        List<int[]> cards = new ArrayList<>();
        int total = 0;
        int currentCoins = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            cards.add(i, new int[]{t, x});
            if (t == 1) {
                currentCoins += x;
            } else {
                for (int coin = 1; coin <= currentCoins; coin++) {

                }
            }
        }
    }

    public static void dfs(int currentIndex, List<int[]> cards, int currentHurt, int h, int currentCoins) {
        if (currentIndex == cards.size()) {
            return;
        }
        if (currentHurt >= h) {
            cases++;
            killCases++;
            return;
        }
        int[] temp = cards.get(currentIndex);
        int t = temp[0];
        int x = temp[1];
        if (t == 1) {
            int tempCoins = currentCoins;
            dfs(currentIndex + 1, cards, currentHurt, h, currentCoins + x);
            currentCoins = tempCoins;
        } else {
            int roundHurt = 0;
            for (int i = 0; i < currentCoins; i++) {
                for (int possibleX = 1; possibleX <= 6; possibleX++) {
                    int tempHert = currentHurt;
                    
                }
            }
        }
    }
}
