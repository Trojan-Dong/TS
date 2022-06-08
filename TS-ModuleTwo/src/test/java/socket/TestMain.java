package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 4555));
            if (socket.isConnected()) {
                try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ) {
                    Message message = new Message();
                    message.setContent(scanner.next());
                    oos.writeObject(message);
                    Message receive = (Message) ois.readObject();
                    System.out.println(receive.getContent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
