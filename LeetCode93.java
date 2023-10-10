import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public static void main(String[] args) {
        List<String> l = restoreIpAddresses("25525511135");
        for (String s : l) {
            System.out.println(s);
        }
    }

    private static int SEG_COUNT = 4;


    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> result = new ArrayList<>();
        if (len < 4 || len > 12) {
            return result;
        }
        int[] ipAddresses = new int[SEG_COUNT];
        dfs(s, 0, 0, ipAddresses, result);
        return result;
    }

    public static void dfs(String s, int start, int segId, int[] ipAddresses, List<String> result) {
        // 找到一种答案
        if (segId == SEG_COUNT) {
            if (start == s.length()) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    resultBuilder.append(ipAddresses[i]);
                    if (i != SEG_COUNT - 1) {
                        resultBuilder.append(".");
                    }
                }
                result.add(resultBuilder.toString());
            }
            return ;
        }

        if (start == s.length()) {
            return ;
        }

        if (s.charAt(start) == '0') {
            ipAddresses[segId] = 0;
            dfs(s, start + 1, segId + 1, ipAddresses, result);
            return ;
        }

        int addr = 0;
        for (int segEnd = start; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr < 256) {
                ipAddresses[segId] = addr;
                dfs(s, segEnd + 1, segId + 1, ipAddresses, result);
            } else {
                break;
            }
        }
    }
}
