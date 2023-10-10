import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode47 {
    private static Set<String> unique = new HashSet<>();
    public static void main(String[] args) {
        List<List<Integer>> result = permuteUnique(new int[] {1,-1,1,2,-1,2,2,-1});
        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> result = new ArrayList<>();

        dfsii(nums, used, result, new ArrayDeque<>());

        return result;
    }

    public static void dfsii(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> currentSequence) {
        if (currentSequence.size() == nums.length) {
            result.add(new ArrayList<>(currentSequence));
            return;
        }

        Set<Integer> usedInThisRound = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int choice = nums[i];
            if (used[i] == false && !usedInThisRound.contains(choice)) {
                currentSequence.addLast(choice);
                used[i] = true;
                usedInThisRound.add(choice);
                dfsii(nums, used, result, currentSequence);
                currentSequence.removeLast();
                used[i] = false;

            }
        }
    }

    public static void dfs(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> current) {
        if (current.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(current);
            if (unique.contains(temp.toString())) {
                return ;
            }
            result.add(new ArrayList<>(current));
            unique.add(temp.toString());
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.addLast(nums[i]);
                used[i] = true;
                dfs(nums, used, result, current);
                current.removeLast();
                used[i] = false;
            }
        }
    }
}
