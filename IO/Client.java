package IO;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    ModelClass mc;

    public void send(ModelClass mc) {
        this.mc = mc;
    }

    private void client() throws Exception {
        Socket socket = null;
        ObjectOutputStream oos = null;
        try {
            while (true) {
                System.out.println("create new socket!");
                try {
                    socket = new Socket("127.0.0.1", 9090);
                    while (true) {
                        if (mc == null) {
                            Thread.sleep(1000);
                            continue;
                        }
                        System.out.println("out object!");
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(mc);
                        mc = null;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(5000);
            }
        } finally {
            if (socket != null) {
                socket.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }

    public Client() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    client();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}
