package iwilllearnjava.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by david on 3/16/2017.
 */
public class ServerChat {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(55555);
        while (true) {
            Socket socket = serverSocket.accept(); // blocking
            System.out.println(socket.getLocalPort());
            InputStream userInput = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(userInput));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream, true);
            String clientSay;
            while ((clientSay = br.readLine()) != null) {
                System.out.println(clientSay);
                if (clientSay.equals("Hello")) {
                    pw.println("Hello u 2");
                } else if (clientSay.equals("buy")) {
                    pw.println("buy\n");
                    System.out.println("Disconnecting client: " + socket.getRemoteSocketAddress());
                    socket.close();
                    break;
                } else {
                    pw.println("echo: " + clientSay);

                }

            }

        }
    }
}
