package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("localhost", 4999);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
                while(true){
                    String serverMessage = in.readLine();
                    if (serverMessage.equals("over")) {
                        break;
                    } else {
                        if(serverMessage.equals("needreply")){
                            String text=input.next();
                            out.println(text);
                        }
                        else{
                            System.out.println(serverMessage);
                        }

                    }
                }
        }
    }
}
