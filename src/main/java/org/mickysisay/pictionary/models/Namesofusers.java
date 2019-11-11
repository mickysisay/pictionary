package org.mickysisay.pictionary.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Namesofusers {
    private static HashMap<String, ArrayList<String>> allUsers = new HashMap<>();
    public static void addUser(String gameName,String userName){

       try {
           if(allUsers.get(gameName) == null){
               ArrayList<String> all = new ArrayList<>();
               all.add(userName);
               allUsers.put(gameName, all);
               System.out.println(allUsers.get(gameName));
           }else {
               ArrayList<String> all = allUsers.get(gameName);
               all.add(userName);
               allUsers.put(gameName, all);
           }
       }catch(Exception e){

       }
    }
    public static void removeUser(String gameName,String userName){
        ArrayList<String> all =  allUsers.get(gameName);
        if(all.contains(userName)){
            all.remove(all.indexOf(userName));
        }
    }
    //gets all the users in a given game
    public static ArrayList<String> getAllUsers (String gameName){
        //might put try/catch here
        return allUsers.get(gameName);
    }
}
