public class LeetCode338 {
    // 给定整数n，计算出从0到n每个数的二进制中1的个数

    public static void main(String[] args) {
        System.out.println(countBits(5));
        String tmp = "abcde";
        System.out.println(tmp.substring(2,5));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + 1;
            }
        }
        return ans;
    }
}
