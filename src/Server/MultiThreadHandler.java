package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiThreadHandler implements Runnable{
    ArrayList<MultiThreadHandler>clients = new ArrayList<>();
    public User user;
    private Socket clientSocket;
    PrintWriter out = null;
    BufferedReader in = null;
    MultiThreadHandler(Socket socket){
        clients.add(this);
        this.clientSocket = socket;
    }

    @Override
    public void run(){
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Welcome to Hangman");
            out.println("1.Register\n2.Sign In");
            out.println("over");
            while(true) {
                String choice = in.readLine();

                if (choice.equals("1")) {
                    while (true) {
                        out.println("Enter a username");
                        String username = in.readLine();
                        if (!user.usernameExists(username)) {
                            out.println("Enter your name");
                            String name = in.readLine();
                            out.println("Enter your password");
                            String password = in.readLine();
                            user.createUser(username, password, name);
                            break;
                        } else {
                            out.println("Username already exists");
                        }
                    }
                } else if (choice.equals("2")) {
                    out.println("Enter your username");
                    String username = in.readLine();
                    out.println("Enter your password");
                    String password = in.readLine();

                    out.println(user.signIn(username,password));

                } else {
                    out.println("Invalid choice");
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
