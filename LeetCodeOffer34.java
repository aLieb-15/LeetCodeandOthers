import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeOffer34 {
    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node4 = new TreeNode(4, node11, null);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4right = new TreeNode(4, node5, node1);
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8, node13, node4right);
        TreeNode root = new TreeNode(5, node4, node8);
        pathSum(root, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        dfs(root, target, list);
        System.out.println(ans.size());
        System.out.println(ans.get(0).size());
        return ans;
    }

    public static void dfs(TreeNode root, int curTarget, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == curTarget) {
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                // ans.add(list);
                list.remove(list.size() - 1);
                return;
            } else {
                return;
            }
        }
        // if (root == null && curTarget == 0) {
        //     List<Integer> t = new ArrayList<>();
        //     t = list;
        //     ans.add(t);
        //     return;
        // }
        // if (root == null && curTarget != 0) {
        //     return;
        // }
        list.add(root.val);
        dfs(root.left, curTarget - root.val, list);
        dfs(root.right, curTarget - root.val, list);
        if (!list.isEmpty()) {
            System.out.println("node finish:" + list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
