public class TryingString {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        System.out.println(sb.length());
        sb.replace(0, 1, "b");
        System.out.println(sb.toString());
        System.out.println(s.substring(0,1));
    }
}
