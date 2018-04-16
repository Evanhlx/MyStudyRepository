import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 10086);
            client.setSoTimeout(10000);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                System.out.println("请输入信息...");
                String inputStr = input.readLine();
                System.out.println("key input >>> " + inputStr);
                //send message to server
                out.println(inputStr);

                if ("bye".equalsIgnoreCase(inputStr)) {
                    flag = false;
                } else {
                    //receive message from server
                    try {
                        String msg = read.readLine();
                        System.out.println("server msg >>> " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("it is server time out ? ");
                    }
                }

//                input.close();
//                if (client != null)
//                    client.close();

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
