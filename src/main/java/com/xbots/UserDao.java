package com.xbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
   private static final String FILE_NAME = "C:\\tmp\\Users.dat";

public List<User> getAllUsers(){
      List<User> userList = null;
      try {
         File file = new File(FILE_NAME);
         if (!file.exists()) {
            User user = new User("gasharma", "Gaurav", "Scrum Master");
            User user2 = new User("arai", "Abhishek", "Software Architect");
            userList = new ArrayList<User>();
            userList.add(user);
            userList.add(user2);
            saveUserList(userList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (List<User>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return userList;
   }


public List<User> getUser(String id){
    List<User> users = getAllUsers();

    for(User user: users){
       if(user.getId().equals(id)){
    	   List<User> list = new ArrayList<>();
    	   list.add(user);
          return list;
       }
    }
    return null;
 }
   private void saveUserList(List<User> userList){
      try {
         File file = new File(FILE_NAME);
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(userList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
}