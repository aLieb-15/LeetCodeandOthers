import java.util.Arrays;

public class LeetCoede53 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i]含义：以i为结尾的连续子数组的最大和
        int[] dp = new int[len];
        // 转移方程：注意这里考虑的是dp[i-1]而不是nums[i-1]
        // dp[i-1] <= 0：则dp[i-1]对dp[i]是负贡献，dp[i-1] + nums[i] < nums[i]
        // 则dp[i] = nums[i]
        // dp[i-1] > 0：则dp[i] = nums[i] + dp[i-1]
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        Arrays.sort(dp);
        return dp[len - 1];
    }

    public static int maxSubArrayPlus(int[] nums) {
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre > 0) {
                res = Math.max(nums[i] + pre, res);
                pre += nums[i];
            } else {
                pre = nums[i];
                res = Math.max(nums[i], res);
            }
        }
        return res;
    }
}
