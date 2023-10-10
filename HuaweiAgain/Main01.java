package HuaweiAgain;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(num, temp);
            }
        }
        int sn = sc.nextInt();
        if (map.keySet().size() == 1) {
            if (sn == nums[0]) {
                System.out.println("0 " + (n - 1)); 
                return;
            } else {
                System.out.println("-1 -1");
                return;
            }
        }
        if (!map.containsKey(sn)) {
            System.out.println("-1 -1");
            return;
        }
        List<Integer> indexs = map.get(sn);
        int minIndex = n, maxIndex = -1;
        for (int i : indexs) {
            if (i > maxIndex) {
                maxIndex = i;
            }
            if (i < minIndex) {
                minIndex = i;
            }
        }
        if (nums[0] == sn && nums[n-1] == sn) {
            int[] twiceNum = new int[2 * n];
            for (int i = 0; i < n; i++) {
                twiceNum[i] = nums[i];
                twiceNum[n + i] = nums[i];
            }
            int start = n - 1, end = n;
            while (twiceNum[start] == sn) {
                start--;
            } 
            start += 1;
            while (twiceNum[end] == sn) {
                end++;
            }
            end = end - 1 - n;
            System.out.println(start + " " + end);
            return ;
        }
        System.out.println(minIndex + " " + maxIndex);
    }
}
