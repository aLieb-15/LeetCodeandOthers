import java.util.Deque;
import java.util.LinkedList;

public class LeetCode20 {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cc = stack.pollLast();
                    if ((c == ')' && cc == '(') || (c == ']' && cc == '[') || (c == '}' && cc == '{')) {
                        // sb
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
