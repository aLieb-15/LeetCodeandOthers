public class LeetCodeOffer58 {
    public static void main(String[] args) {
        System.out.println(reverseWords("   the    sky is blue   "));
    }

    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        if (s.length() == 1 && s.charAt(0) != ' ') {
            return s;
        }
        if (s.length() == 1 && s.equals(" ")) {
            return new String("");
        }
        int len = s.length();
        int l = 0;
        int r = len - 1;
        // 去除前缀、后缀空格
        while (l < s.length() && s.charAt(l) == ' ') {
            l++;
        }
        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        StringBuilder sb = new StringBuilder();
        // 先将整个句子翻转，再将每个单词分别翻转
        for(int i = l; i <= r; i++) {
            // 去除单词之间的多余空格
            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            }
            sb.append(s.charAt(i));
        }
        System.out.println("sb:" + sb.toString() + "END");
        // 接下来进行翻转
        sb = process(sb, 0, sb.length() - 1);
        System.out.println("reverse sb:" + sb.toString() + "END");
        for (int start = 0; start < sb.length(); ) {
            int end = start;
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            sb = process(sb, start, end - 1);
            start = end + 1;
        }
        return sb.toString();
    }

    public static StringBuilder process(StringBuilder sb, int l, int r) {
        String s = sb.toString();
        while (l < r) {
            String temp = s.substring(l, l + 1);
            sb.replace(l, l + 1, s.substring(r, r + 1));
            sb.replace(r, r + 1, temp);
            l++;
            r--;
        }
        return sb;
    }
}
