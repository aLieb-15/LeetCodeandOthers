import java.util.Arrays;

public class LeetCodeFaceTest61 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{10,11,0,12,6}));
    }

    public static boolean isStraight(int[] nums) {
        int zeroCount = 0;
        Arrays.sort(nums);
        int pre = -1;
        int i = 0;
        while (nums[i] == 0 && i < nums.length) {
            zeroCount++;
            i++;
        }
        while (i < nums.length) {
            if (pre == -1) {
                pre = nums[i];
                i++;
            } else {
                if (nums[i] == pre) {
                    return false;
                }
                if (nums[i] - pre != 1) {
                    int delta = nums[i] - pre;
                    if (zeroCount >= delta) {
                        zeroCount -= delta;
                    } else {
                        return false;
                    }
                }
                pre = nums[i];
                i++;
            }
        }
        return true;
    }
}
