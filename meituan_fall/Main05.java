package meituan_fall;

import java.util.*;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int maxV = 0;
        int maxK = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (maxV < map.get(num)) {
                maxV = map.get(num);
                maxK = num;
            }
        }
        int ans = 0;
        Set<String> eatSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && i != j; j++) {
                String s1 = String.valueOf(nums[i]) + ", " + String.valueOf(nums[j]);
                String s2 = String.valueOf(nums[j]) + ", " + String.valueOf(nums[i]);
                
            }
        }
        for (int i : map.keySet()) {
            if (i == maxK) {
                continue;
            }
            String temp = String.valueOf(maxK) + ", " + String.valueOf(i);
            if (!eatSet.contains(temp)) {
                eatSet.add(temp);
                ans++;
            }
        }
        if (map.get(maxK) >= 2) {
            ans++;
        }
        System.out.println(ans);

    }
}
