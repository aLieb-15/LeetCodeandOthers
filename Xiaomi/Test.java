package Xiaomi;

public class Test {
    public static double getDistance(int x, int y, int i, int j) {
        int xGap = Math.abs(x - i);
        int yGap = Math.abs(y - j);
        return Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
    }
    public static void main(String[] args) {
        System.out.println((int)Math.floor(getDistance(0, 0, 9, 4)));
    }
}
