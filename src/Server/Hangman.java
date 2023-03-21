package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    ArrayList<String>words = new ArrayList<>();
    Socket userSocket;
    Scanner reader = new Scanner(new File("words.txt"));
    PrintWriter out;
    BufferedReader in;

    Hangman(Socket socket) throws FileNotFoundException {
        this.userSocket = socket;
    }


}
