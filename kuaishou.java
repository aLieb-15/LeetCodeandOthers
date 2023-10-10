import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Node head = new Node(3);
        Node n1 = new Node(2);
        Node n2 = new Node(0);
        Node n3 = new Node(-4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(cycleLinkedList(head).val);
    }

    public static Node cycleLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                Node tmp = head;
                while (slow != tmp) {
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }
}