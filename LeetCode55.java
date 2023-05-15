
public class LeetCode55 {
    public static void main(String[] args) {
        // System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        // System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
        // System.out.println("hello?");
        System.out.println(jump(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }));
        // int[] err = new int[10000];
        // for (int i = 0; i < 9999; i++) {
        // err[i] = 1;
        // }
        // System.out.println(jump(err));
    }

    public static boolean canJump(int[] nums) {
        // 不用跳的情况
        if (nums.length == 1) {
            return true;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        // if (dp[nums.length - 2] != 0) {
        // dp[nums.length - 2] = 1;
        // }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length && dp[i + j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
            if (dp[i] != 1) {
                dp[i] = -1;
            }
        }
        if (dp[0] == 1) {
            return true;
        } else {
            return false;
        }
    }

    // 超时，需要优化
    public static boolean process1(int cur, int[] nums) {
        if (cur == nums.length - 1) {
            return true;
        }
        if (nums[cur] == 0) {
            return false;
        }
        if (cur + nums[cur] >= (nums.length - 1)) {
            return true;
        }
        boolean right = false;
        for (int i = 1; i <= nums[cur]; i++) {
            // 到底要不要往左找，初步判断是一定不用往左找
            // 因为按照从左到右调用的顺序，cur左边的情况是涵盖了cur的情况的
            // 这里必须删掉，否则会循环的调用把栈爆掉
            // if (cur - i > 0) {
            // left = left || process(cur - i, nums);
            // }
            if (cur + i < nums.length) {
                right = right || process1(cur + i, nums);
            }
        }
        return right;
    }

    public static boolean canJumpTan(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i < cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    // 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0
    // 0, 0, 0, 0, -1, -1, 1, 0, 1, -1, -1, 0
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // for (int i : dp) {
        // i = -1;
        // }
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = -1;
                continue;
            }
            // 一步就能走到的情况
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
            } else {
                int minJump = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    if (nums[i + j] == 0) {
                        continue;
                    }
                    if (dp[i + j] == -1) {
                        continue;
                    }
                    minJump = Math.min(minJump, dp[i + j]);
                }
                if (minJump == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = minJump + 1;
                }
            }
        }
        System.out.print("dp:");
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return dp[0];
    }

    public static int jumpTan(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 从后往前，找可能到达aim的点
        // 又要求步数最小，那么在所有能一步到达aim的点中，我们应该选择下标最小的
        // 因此循环内部采用从左到右遍历，找出第一个能够一步到达aim的点
        // 这里的aim初始值为pos，每次循环都往前走
        int pos = nums.length - 1;
        int steps = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
