public class Code01_Upstairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        // 1836311903
    }

    // public static int climbStairs(int n) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     if (n == 2) {
    //         return 2;
    //     }
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }


    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int p = 1, q = 2, t = 0;
        for (int i = 3; i <= n; i++) {
            t = p + q;
            p = q;
            q = t;
        }
        return t;
    }
    // public static int process(int cur, int n) {
    //     if (cur == (n - 1)) {
    //         return 1;
    //     }
    //     if (cur == 1) {
    //         return 1;
    //     }
    //     if (cur == 2) {
    //         return 2;
    //     }
    //     return process(cur - 1, n) + process(cur - 2, n);
    // }
}
