package ant;

public class test {
    public static void main(String[] args) {
        String s = "123456";
        String l = s.replace("6", "0");
        String h = s.replace("6", "9");
        System.out.println(l);
        System.out.println(h);
        System.out.println(s);
    }
}
