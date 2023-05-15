package huazi;

import java.io.BufferedReader;
import java.io.*;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Another02 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer scc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        scc.nextToken();
        int l = (int)scc.nval;
        scc.nextToken();
        int r = (int)scc.nval;
        scc.nextToken();
        int n = (int)scc.nval;
        
        //Scanner sc = new Scanner(System.in);
        //int l = sc.nextInt();
        //int r = sc.nextInt();
        //int n = sc.nextInt();
        ArrayDeque<Integer> d = new ArrayDeque<>();
        Set<Integer> s = new HashSet<>();
        for (int i = l; i <= r; i++) {
            d.addLast(i);
            s.add(i);
        }
        for (int i = 0; i < n; i++) {
            scc.nextToken();
            int op = (int)scc.nval;
            scc.nextToken();
            int t = (int)scc.nval;
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
