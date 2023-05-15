public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        realQuickSort(arr, 0, 3);
        for (int i : arr) {
            System.out.println(i);;
        }
    }

    public static void myQuickSort(int[] nums, int l, int r) {
        int l0 = l, r0 = r;
        if (l >= r) {
            return;
        }
        while (l < r) {
            while (l < r && nums[l] <= nums[r]) {
                l++;
            }
            while (l < r && nums[l] <= nums[r]) {
                r--;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }

        myQuickSort(nums, l0, r - 1);
        myQuickSort(nums, r + 1, r0);
    }

    public static void realQuickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(nums, l, r);
        realQuickSort(nums, l, p - 1);
        realQuickSort(nums, p + 1, r);
    }

    public static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[i + 1];
        nums[i + 1] = nums[r];
        nums[r] = tmp;
        return i + 1;
    }
}
