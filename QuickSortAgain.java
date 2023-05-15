import java.util.Random;

public class QuickSortAgain {
    public static void main(String[] args) {
        int[] check = new int[]{1, 5, 4, 3, 2, 1};
        printArray(check);
        quickSort(check, 0, check.length - 1);
        printArray(check);
    }

    public static void printArray(int[] nums) {
        System.out.println("Array:");
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot + 1, r);
    }

    public static int partition(int[] nums, int p, int r) {
        int i = p - 1;
        Random random = new Random();
        int randomIndex = random.nextInt(r - p + 1) + p;
        int temp = nums[r];
        nums[r] = nums[randomIndex];
        nums[randomIndex] = temp;
        for (int j = p; j < r; j++) {
            if (nums[j] <= nums[r]) {
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
