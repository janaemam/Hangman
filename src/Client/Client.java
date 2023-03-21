package Client;

import java.io.*;
import java.net.Socket;

public class Client {
    Client() throws IOException {
        Socket socket = new Socket("localhost", 4999);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }



    public void Run(){

    }

}
