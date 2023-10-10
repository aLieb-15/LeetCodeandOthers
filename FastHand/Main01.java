package FastHand;

public class Main01 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return true;
        }

        char[] chs = s.toCharArray();
        int p = 0;
        int q = len - 1;
        while (p < q) {
            while (p < len && !Character.isAlphabetic(chs[p]) && !Character.isDigit(chs[p])) {
                p++;
            }
            while (q >= 0 && !Character.isAlphabetic(chs[q]) && !Character.isDigit(chs[q])) {
                q--;
            }
            if (p >= len || q < 0) {
                break;
            }
            if (Character.toLowerCase(chs[p]) != Character.toLowerCase(chs[q])) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }
}
