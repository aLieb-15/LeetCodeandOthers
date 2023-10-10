package javaBase.Singleton;

public class tx {

    public static double getArch(int hour, int minute) {
        if (hour < 0 || hour > 24 || minute < 0 || minute >= 60 || (hour == 24 && minute != 0)) {
            System.out.println("Argument false");
            return -1;
        }
        if (hour > 12) {
            hour = hour % 12;
        }
        double archHour = hour / 12.0 * 360;
        double archMin = minute / 60.0 * 360;
        archHour = archHour + minute / 60 * 30;

        double result = Math.abs(archHour - archMin);
        if (result > 180) {
            return 360 - result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(getArch(23, 10));
    }
}
// input：几点几分 12:00
// output：时针分针的夹角