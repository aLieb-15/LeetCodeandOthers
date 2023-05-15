import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode46 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3, 4, 5});
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

    // public static List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();

    //     List<Integer> output = new ArrayList<Integer>();
    //     for (int num : nums) {
    //         output.add(num);
    //     }

    //     int n = nums.length;
    //     backtrack(n, output, res, 0);
    //     return res;
    // }

    // public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
    //     // 所有数都填完了
    //     if (first == n) {
    //         res.add(new ArrayList<Integer>(output));
    //     }
    //     for (int i = first; i < n; i++) {
    //         // 动态维护数组
    //         Collections.swap(output, first, i);
    //         // 继续递归填下一个数
    //         backtrack(n, output, res, first + 1);
    //         // 撤销操作
    //         Collections.swap(output, first, i);
    //     }
    // }
}
