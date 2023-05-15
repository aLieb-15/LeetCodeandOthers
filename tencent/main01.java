package tencent;

// 81.82% 正常方法，不知道为什么
public class main01 {
    public static void main(String[] args) {
        
    }

    public ListNode reorderList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        ListNode q = p.next;
        if (q != null) {
            q = q.next;
        }
        if (q == null) {
            return head;
        }
        while (q != null) {
            ListNode nxt = q.next;
            if (nxt == null) {
                q.next = p;
                pre.next = q;
                p.next.next = null;
                break;
            } else {
                nxt = nxt.next;
                q.next.next = p;
                pre.next = q;
                p.next.next = nxt;
                pre = p.next;
                p = nxt;
                q = p.next;
                if (q == null) {
                    break;
                }
                q = q.next;
            }
        }
        return dummy.next;
    }
}
