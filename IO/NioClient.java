package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {
    public static void main(String[] args) throws IOException, InterruptedException{
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 9090));
        channel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    if (socketChannel.isConnectionPending()) {
                        socketChannel.finishConnect();
                    }
                    socketChannel.configureBlocking(false);
                    ByteBuffer buffer = ByteBuffer.wrap("client sent data".getBytes());
                    socketChannel.write(buffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
                Thread.sleep(1000);
            }
        }
    }


    public static void read(SelectionKey key) throws IOException{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        int len = socketChannel.read(buffer);
        if (len != -1) {
            System.out.println("client recieved message:" + new String(buffer.array(), 0, len));
        }
    }
}
