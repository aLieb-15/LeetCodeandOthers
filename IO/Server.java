package IO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.imageio.IIOException;
import javax.jws.WebParam.Mode;


public class Server {
    private static ServerSocket serverSocket = null;
    private static Map<String, ModelClass> info= new HashMap<>();

    static {
        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            System.out.println("create serverSocket error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    Iterator<Map.Entry<String, ModelClass>> it = info.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<String, ModelClass> entry = it.next();
                        ModelClass mc = (ModelClass)entry.getValue();
                        System.out.println(mc.name);
                        System.out.println(mc.m1.get(0));
                        System.out.println(mc.m2.get(0).value);
                        System.out.println();
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        System.out.println("*****服务器已启动，等待客户端连接*****");
                        Socket socket = serverSocket.accept();
                        System.out.println("*****已连接客户端*****");
                        new SST(socket).start();
                    } catch (Exception e) {
                        System.out.println("socket accept error:" + e.getMessage());
                    }
                }
            }
        }).start();
    }

    static class SST extends Thread {
        private Socket socket;
        private String key;

        public SST(Socket socket) {
            this.socket = socket;
            key = socket.getInetAddress().toString() + "/" + socket.getPort();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            ObjectInputStream ois = null;
            try {
                while(true) {
                    ois = new ObjectInputStream(socket.getInputStream());
                    Object obj = ois.readObject();
                    ModelClass mc = (ModelClass) obj;
                    info.put(key, mc);
                }
            } catch (Exception e) {
                System.out.println("get msg error" + e.getMessage());
            } finally {
                if (info.containsKey(key)) {
                    info.remove(key);
                }
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch(IOException e) {
                    System.out.println("br close error:" + e.getMessage());
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch(IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
