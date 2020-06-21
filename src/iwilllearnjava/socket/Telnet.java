package iwilllearnjava.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by david on 3/16/2017.
 */
public class Telnet {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 55555);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            pw.println(userInput);
//            System.out.println(socket.isConnected());
            String serverSay = br.readLine();
            System.out.println(serverSay);
            if (serverSay.equals("buy")) {
                System.out.println("Disconnected from server");
                socket.close();
                break;
            }
//            System.out.println(pw.checkError());
        }

//        pw.println("Hello");
//        System.out.println(br.readLine());
        br.close();
        pw.close();
//        socket.close();
    }
}
