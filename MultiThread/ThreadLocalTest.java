package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();
    private String jth;

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        // ThreadPoolExecutor

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("hhhhhhhhhhhhhh");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}
