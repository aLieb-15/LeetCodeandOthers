package huazi;

import java.security.GeneralSecurityException;
import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        Map<String, Set<Integer>> grassMap = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String key = x + "," + y;
            Set<Integer> set = grassMap.getOrDefault(key, new HashSet<>());
            set.add(i);
            grassMap.put(key, set);
        }
        int days = 0;
        while (true) {
            Set<String> keys = grassMap.keySet();
            HashSet<String> tempSet = new HashSet<>(keys);
            Set<String> nKeys = new HashSet<>();
            Map<String, Set<Integer>> tmpMap = new HashMap<>(grassMap);
            for (String key : tempSet) {
                Set<Integer> set = grassMap.get(key);
                int x = Integer.parseInt(key.split(",")[0]);
                int y = Integer.parseInt(key.split(",")[1]);
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        String nKey = i + "," + j;
                        if (i == x && j == y) {
                            continue;
                        }
                        if (tempSet.contains(nKey)) {
                            Set<Integer> nSet = grassMap.get(nKey);
                            
                        }
                    }
                }
            }
        }
    }
}
