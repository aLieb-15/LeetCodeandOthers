package huazi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


class Node {
    public int res;
    public Node pre;
    public Node nxt;

    Node (int res) {
        this.res = res;
    }
}

public class Main02 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();
        ArrayDeque<Integer> d = new ArrayDeque<>();
        Set<Integer> s = new HashSet<>();
        int len = r - l + 1;
        
        Node head = new Node(-1);
        Node tail = new Node(-1);
        head.nxt = tail;
        head.pre = null;
        tail.pre = head;
        tail.nxt = null;


        StreamTokenizer scc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        scc.nextToken();
        int l = (int)scc.nval;
        scc.nextToken();
        int r = (int)scc.nval;
        scc.nextToken();
        int n = (int)scc.nval;

        for (int i = l; i <= r; i++) {
            d.addLast(i);
            s.add(i);
        }
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            int t = sc.nextInt();
            if (op == 1) {
                if (t > d.size()) {
                    continue;
                } 
                while (t > 0) {
                    int x = d.pollFirst();
                    s.remove(x);
                    t--;
                }
            } else if (op == 2) {
                if (!s.contains(t)) {
                    continue;
                }
                ArrayDeque<Integer> tmp = new ArrayDeque<>();
                while (d.peekFirst() != t) {
                    int x = d.pollFirst();
                    tmp.addLast(x);
                }
                d.pollFirst();
                while (!tmp.isEmpty()) {
                    int x = tmp.pollLast();
                    d.addFirst(x);
                }
                s.remove(t);
            } else {
                d.addLast(t);
                s.add(t);
            }
        }
        System.out.println(d.peekFirst());
    }
}
