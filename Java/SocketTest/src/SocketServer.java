import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10086);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                System.out.println("client connet server success !");
                new Thread(new SocketTask(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketTask implements Runnable {

        Socket socket = null;

        public SocketTask(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            try {
                PrintStream out = new PrintStream(socket.getOutputStream());
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                boolean flag = true;
                while (flag) {
                    //receive msg from client
                    String msg = read.readLine();
                    System.out.println("msg from client >>> " + msg);
                    if (msg == null || msg.equals("") || "bye".equalsIgnoreCase(msg)) {
                        flag = false;
                    } else {
                        //print msg to client
                        out.println("this is form server,you message is ( " + msg + " )");
                    }
                }

                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
