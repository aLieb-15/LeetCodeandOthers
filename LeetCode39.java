import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode39 {
    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, used, target, new ArrayDeque<>(), result, 0, 0);
        return result;
    }

    public static void dfs(int[] candidates, boolean[] used, int target, Deque<Integer> current,
            List<List<Integer>> result, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            int choice = candidates[i];
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.addLast(candidates[i]);
            used[i] = true;
            dfs(candidates, used, target, current, result, sum + candidates[i], i + 1);
            current.removeLast();
            used[i] = false;

        }
    }
}
