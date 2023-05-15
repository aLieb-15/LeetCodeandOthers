package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class AioServer {
    public static void main(String[] args) {
        try {
            AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            System.out.println("waiting for connection......");
            serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    // TODO Auto-generated method stub
                    System.out.println("connected, processing data......");
                    serverSocketChannel.accept(null, this);
                    handleData(result);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    // TODO Auto-generated method stub
                    System.out.println("failed......");
                }
            });
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleData(AsynchronousSocketChannel result) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                // TODO Auto-generated method stub
                if (result > 0) {
                    attachment.flip();
                    byte[] array = attachment.array();
                    System.out.println(new String(array));
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                // TODO Auto-generated method stub
                System.out.println("failed!");
            }
        });
    }
}
