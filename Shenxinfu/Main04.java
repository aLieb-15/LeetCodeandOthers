package Shenxinfu;

import java.util.Scanner;
import java.util.Stack;

public class Main04 {

    private static Stack<Character> stack = new Stack<>();

    private static String inputSeq;

    // public static void stackOps(int index, StringBuilder sb, Stack<String> stack) {
    //     if (index == inputSeq.length()) {
    //         Stack<String> tempStack = new Stack();
    //         while (!stack.isEmpty()) {
    //             String temp = stack.pop();
    //             sb.append(temp);
    //             tempStack.push(temp);
    //         }
    //         while (!tempStack.isEmpty()) {
    //             stack.push(tempStack.pop());
    //         }
    //         System.out.println(sb.toString());
    //         return;
    //     }
    //     String curr = String.valueOf(inputSeq.charAt(index));
    //     // 入栈当前元素
    //     stack.push(curr);
    //     // 不出栈当前元素
    //     stackOps(index + 1, sb, stack);
    //     // 出栈当前元素
    //     sb.append(stack.pop());
    //     stackOps(index + 1, sb, stack);
    // }

    public static void backtrack(int index, StringBuilder current, Stack<Character> stack) {
        if (index == inputSeq.length() && stack.isEmpty()) {
            System.out.println(current.toString());
            return ;
        }
        if (!stack.isEmpty()) {
            char top = stack.pop();
            current.append(top);
            backtrack(index, current, stack);
            stack.push(top);
            current.deleteCharAt(current.length() - 1);
        }

        if (index < inputSeq.length()) {
            stack.push(inputSeq.charAt(index));
            backtrack(index + 1, current, stack);
            stack.pop();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputSeq = sc.nextLine();
        if (inputSeq == null) {
            return;
        }
        backtrack(0, new StringBuilder(), stack);
    }
}
