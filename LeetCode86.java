import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode86 {
    public static void main(String[] args) {
        
    }

    public ListNode partition(ListNode head, int x) {
        ListNode little = new ListNode(-1);
        ListNode pl = little;
        ListNode bigger = new ListNode(-1);
        ListNode bl = bigger;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                pl.next = new ListNode(p.val);
                pl = pl.next;
                p = p.next;
            } else if (p.val > x) {
                bl.next = new ListNode(p.val);
                bl = bl.next;
                p = p.next;
            } else {
                p = p.next;
            }
        }
        pl.next = new ListNode(x);
        pl.next.next = bigger.next;
        Deque<Integer> deque = new 
        return little.next;
    }
}
