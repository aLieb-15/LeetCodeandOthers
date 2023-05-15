enum FaceTo {
    North, West, South, East
}

public class LeetCode1041 {
    private static int x = 0, y = 0;
    private static FaceTo faceTo = FaceTo.North;

    public static boolean isRobotBounded(String instructions) {
        char[] chs = instructions.toCharArray();
        int len = chs.length;
        if (len == 1) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            for (char c : chs) {
                if (c == 'G') {
                    move();
                    System.out.println("(" + x + "," + y + ")");
                } else {
                    spin(c);
                }
            }
        }

        if (x == 0 && y == 0 && faceTo == FaceTo.North) {
            return true;
        }
        return false;
    }

    public static void spin(char c) {
        if (c == 'L') {
            switch (faceTo) {
                case North:
                    faceTo = FaceTo.West;
                    break;
                case West:
                    faceTo = FaceTo.South;
                    break;
                case South:
                    faceTo = FaceTo.East;
                    break;
                case East:
                    faceTo = FaceTo.North;
                    break;
                default:
                    break;
            }
        } else {
            switch (faceTo) {
                case North:
                    faceTo = FaceTo.East;
                    break;
                case West:
                    faceTo = FaceTo.North;
                    break;
                case South:
                    faceTo = FaceTo.West;
                    break;
                case East:
                    faceTo = FaceTo.South;
                    break;
                default:
                    break;
            }
        }
    }

    public static void move() {
        switch (faceTo) {
            case North:
                y++;
                break;
            case West:
                x--;
                break;
            case South:
                y--;
                break;
            case East:
                x++;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        String s = "GGLLGG";
        System.out.println(isRobotBounded(s));
    }
}
