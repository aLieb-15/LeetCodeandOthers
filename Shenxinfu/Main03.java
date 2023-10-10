package Shenxinfu;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numString = sc.nextLine();
        String[] nums = numString.split(",");
        int[] numsArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArray[i] = Integer.valueOf(nums[i]);
        }

        int ans = 0;
        int start = 0;

        for (int i = 0; i < numsArray.length; i++) {
            if (i > 0 && numsArray[i] >= numsArray[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        System.out.println(ans);
    }
}
