package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;

public class AioClient {
    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(next.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
