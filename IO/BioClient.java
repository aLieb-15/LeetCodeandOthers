package IO;

import java.io.IOException;
import java.net.Socket;

public class BioClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            socket.getOutputStream().write("my data!".getBytes());
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
