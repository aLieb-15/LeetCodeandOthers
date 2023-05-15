//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class LeetCodeOffer55 {
    public static void main(String[] args) {
        // String str1 = new String("abc");
        // String str2 = new String("abc");
        // System.out.println(str1 == str2);
        // System.out.println(str1.equals(str2));
        TreeNode root = new TreeNode(100);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right));
    }
}


