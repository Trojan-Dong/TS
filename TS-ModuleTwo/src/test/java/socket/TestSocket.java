package socket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    private static Logger logger = LoggerFactory.getLogger(TestSocket.class);

    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(4555);
        Socket socket = null;
        while ((socket = socketServer.accept()) != null) {
            logger.info("socket connected");
//            try (OutputStream os = socket.getOutputStream();
//                 InputStream is = socket.getInputStream();
//                 InputStreamReader isr = new InputStreamReader(is)) {
//                char[] buffer = new char[1024];
//                isr.read(buffer, 0, buffer.length);
//                System.out.println(new String(buffer));
//                os.write("已收到请求并处理".getBytes());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                Message message = (Message) ois.readObject();
                System.out.println(message.getContent());
                message.setContent("i have receive：" + message.getContent());
                oos.writeObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
