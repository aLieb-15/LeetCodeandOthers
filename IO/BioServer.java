package IO;

import java.io.IOError;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static Socket socket = null;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            while (true) {
                System.out.println("waiting for connection....");
                socket = serverSocket.accept();
                System.out.println("connected");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] buffer = new byte[1024];
                        try {
                            System.out.println("waiting for data....");
                            int len = socket.getInputStream().read(buffer);
                            System.out.println(new String(buffer, 0, len));
                            System.out.println("data got");
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } 
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
