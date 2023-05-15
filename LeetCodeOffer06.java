public class LeetCodeOffer06 {
    public static int len = 0;
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        reversePrint(n1);
    }

    public static int[] reversePrint(ListNode head) {
        printLinkedList(head);
        ListNode p = head;
        int[] ans = new int[len];
        int i = 0;
        while (p != null) {
            ans[i] = p.val;
            p = p.next;
            i++;  
        }
        return ans;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            len++;
        }
        return pre;
    }

    public static void printLinkedList(ListNode head) {
        ListNode p = head;
        System.out.println("LinkedList Node vals:");
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
    }
}
