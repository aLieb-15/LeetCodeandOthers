package tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class main05 {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Set<Integer> delSet = new HashSet<>();
        dfs(nums, 0, delSet, k);
        System.out.println(ans);
    }

    /**
     * 
     * @param nums
     * @param index
     * @param delList   删除的元素的list，防止元素重复，存储的是下标
     * @param k
     */
    public static void dfs(int[] nums, int index, Set<Integer> delList, int k) {
        if (index == nums.length) {
            return ;
        }
        delList.add(index);
        int i = 0;
        while (delList.contains(i)) {
            i++;
        }
        int g = nums[i];
        for (i = 0; i < nums.length && !delList.contains(i); i++) {
           for (int j = 0; j < nums.length && !delList.contains(j) && j != i; j++) {
            int tmp = gcd(nums[i], nums[j]);
            g = Math.max(g, tmp);
           }
        }
        if (g == k) {
            ans++;
        }
        dfs(nums, index+1, delList, k);
        delList.remove(index);
        dfs(nums, index+1, delList, k);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
