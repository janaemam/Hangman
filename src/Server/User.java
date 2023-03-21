package Server;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public static ArrayList<User> users = new ArrayList<>();
    File file = new File("Accounts.txt");

    BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(file,true));
    Scanner reader = new Scanner(file);
    String username;
    String password;
    String name;
    User () throws IOException {}
    User( String name,String username, String password) throws IOException {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String createUser(String name,String username,String password) throws IOException {

        User newUser = new User(name,username, password );
        users.add(newUser);
        bufferedWriter.write(name+":"+username+":"+password+"\n");
        bufferedWriter.flush();


        return "User added successfully";
    }
    public String signIn(String username,String password){
        boolean correctUname=false;
        boolean correctPass=false;
        String message="";
        for(User u: users){
            if(u.username.equals(username) && u.password.equals(password)){
                correctPass=true;
                correctUname=true;
            }
            else if(u.username.equals(username) && !u.password.equals(password)){
                correctPass=false;
            }
            else if(!u.username.equals(username) && u.password.equals(password)){
                correctUname=true;
            }
        }
        if(correctPass&&correctUname){
            message="Logged in Successfully ";
        }
        else if(correctPass&&!correctUname){
            message= "404 username Doesn't exist";
        }
        else if(correctUname&&!correctPass){
           message= "401 Unauthorized Access";
        }
        return message;
    }
    public boolean usernameExists(String uname){
        boolean flag = false;
        if(users.isEmpty()){
            return flag;
        }
        for(User u: users){
            if(u.username.equals(uname)){
                flag = true;
            }
        }
        return flag;
    }
    public void uploadFiles() throws IOException {
        while(reader.hasNext()){
            String line = reader.nextLine();
            String[] user = line.split(":");
            User newUser = new User(user[0], user[1], user[2]);
            users.add(newUser);
        }
    }
}
