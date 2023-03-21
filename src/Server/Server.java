package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public ServerSocket serverSocket;


    public void startServer(){
        try {
            serverSocket = new ServerSocket(4999);
            while(!serverSocket.isClosed()){

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected"+clientSocket.getInetAddress().getHostAddress());
                MultiThreadHandler handler = new MultiThreadHandler(clientSocket);
                new Thread(handler).start();
            }


        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
