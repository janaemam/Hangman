package Server;

import java.util.ArrayList;

public class User {
    public static ArrayList<User> users = new ArrayList<>();
    String username;
    String password;
    String name;
    User(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }

   /* public boolean createUser(String line){
        boolean flag=true;
        String[] user = line.split(",");
        if(user.length !=3){
            flag = false;
          throw new IllegalArgumentException("Invalid input");
        }
        User newUser = new User(user[0], user[1], user[2]);
        users.add(newUser);
        return flag;
    }*/
    public boolean createUser(String username,String password,String name){

        User newUser = new User(username, password, name);
        users.add(newUser);
        return true;
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
   /* public boolean signIn(String line){
        boolean flag=true;
        String[] user = line.split(",");
        if(user.length !=2){
            flag= false;
            throw new IllegalArgumentException("Invalid input");
        }
        for(User u: users){
            if(u.username.equals(user[0]) && u.password.equals(user[1])){
                flag= true;
            }
        }
        return flag;
    }*/
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
}
