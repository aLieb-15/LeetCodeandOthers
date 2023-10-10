package qianxin;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        letterCombinations(s);
    }

    public static void letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            System.out.println("[]");
        }
        Map<Character, String> map = new HashMap<>();
        map.put('1', "abc");
        map.put('2', "def");
        map.put('3', "ghi");
        map.put('4', "jkl");
        map.put('5', "mno");
        map.put('6', "pqr");
        map.put('7', "stu");
        map.put('8', "vwx");
        map.put('9', "yz");
        dfs(combinations, map, digits, 0, new StringBuilder());
        System.out.print("[");
        for (int i = 0; i < combinations.size(); i++) {
            System.out.print("\'");
            System.out.print(combinations.get(i));
            System.out.print("\'");
            if (i != combinations.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void dfs(List<String> combinations, Map<Character, String> map,
    String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int count = letters.length();
            for (int i = 0; i < count; i++) {
                sb.append(letters.charAt(i));
                dfs(combinations, map, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
