package JVM;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class testHashCode {
    public static void main(String[] args) {
        String s = "jth";
        System.out.println(s.hashCode());
        System.out.println(System.identityHashCode(s));
        // ServerSocket serverSocket = new ServerSocket(8081);
    }
}
