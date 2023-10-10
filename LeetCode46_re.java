import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class LeetCode46_re {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> currentSequence = new ArrayDeque<>();

        dfs(nums, used, result, currentSequence);

        return result;
    }

    public static void dfs(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> currentSequence) {
        if (currentSequence.size() == nums.length) {
            result.add(new ArrayList<>(currentSequence));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                currentSequence.addLast(nums[i]);
                used[i] = true;
                dfs(nums, used, result, currentSequence);
                currentSequence.removeLast();
                used[i] = false;
            }
        }
    }
}
