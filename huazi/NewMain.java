package huazi;

import java.util.*;

class Node {
    public Node pre;
    public Node next;
    public int val;
    public boolean used;
}

public class NewMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();

        Node head = new Node();
        Node tail = new Node();

        List<Node> list = new ArrayList<>();

        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;

        Node p = head;
        int curSize = 0;
        for (int i = l; i <= r; i++) {
            Node tmp = new Node();
            tmp.val = i;
            tmp.next = p.next;
            tmp.pre = p;
            p.next = tmp;
            tmp.next.pre = tmp;
            p = p.next;
            list.add(tmp);
            curSize++;
        }

        for (int i = 0; i < n; i++) {
            int opsType = sc.nextInt();
            int opsArg = sc.nextInt();
            if (opsType == 1) {
                if (opsArg > curSize) {
                    continue;
                }
                p = head.next;
                for (int j = 0; j < opsArg; j++) {
                    p.used = true;
                    p = p.next;
                }
                head.next = p;
                p.pre = head;
            } else if (opsType == 2) {
                Node tmp = list.get(opsArg - l);
                if (tmp.used) {
                    continue;
                }
                tmp.used = true;
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;
            } else {
                Node tmp = list.get(opsArg - l);
                if (!tmp.used) {
                    continue;
                }
                tmp.pre = tail.pre;
                tmp.next = tail;
                tail.pre = tmp;
            }
        }
        System.out.println(head.next.val);
    }
}
