public class temp1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        // nextPermutation(nums);
        int x = 100;
        for (; x > 19; x--)
        System.out.println(x);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        int i = len - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        System.out.println("i" + i);
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            System.out.println("j" + j);
        }
        reverse(nums, i + 1, len - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int l, int r) {
        for (int i = l; i <= (r - l) / 2 + l; i++) {
            swap(nums, i, l + r - i);
        }
    }
}
