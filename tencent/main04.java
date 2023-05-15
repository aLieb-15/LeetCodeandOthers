package tencent;

import java.util.Scanner;

// 31.25% 暴力解法
public class main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isGood(nums, i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 判断是否满足所有数字乘积等于所有数字的异或
     * @param nums  数组
     * @param l     范围左边界，闭区间
     * @param r     范围右边界，闭区间
     * @return
     */
    public static boolean isGood(int[] nums, int l, int r) {
        if (l == r) {
            return true;
        }
        int xor = nums[l];
        int mul = nums[l];
        for (int i = l + 1; i <= r; i++) {
            xor = xor ^ nums[i];
            mul = mul * nums[i];
        }
        return (xor == mul);
    }
}
