public class LeetCodeOffer36 {
    public static Node head, pre;
    public static void main(String[] args) {
        
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};