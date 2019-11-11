package org.mickysisay.pictionary.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Exchangepixel {
    private ArrayList<String> wordList= new ArrayList<>(Arrays.asList("Cat","Dog","Horse","Nail","Man","Angel","Eyeball", "Pizza", "Angry", "Fireworks", "Pumpkin", "Baby", "Flower", "Rainbow", "Beard", "Flying saucer", "Recycle", "Bible", "Giraffe", "Sand castle", "Bikini", "Glasses", "Snowflake"));
    private String all;
   // private ArrayList<String> allUsers = new ArrayList<>();
    private String url;
    private String chosenWord;
//    public Exchangepixel(String userName){
//        this.allUsers.add(userName);
//    }
    public void setChosenWord(){
       int num = (int) (Math.random()*wordList.size());
        chosenWord =wordList.get(num);
       wordList.remove(chosenWord);

    }
    public String getChosenWord(){
        return chosenWord;
    }
    public String getAll(){
        return all;
    }
    public String getUrl(){
        return url;
    }
    public void setAll(String aall){
        all = aall;
    }
    public void setUrl(String aurl){
        url = aurl;
    }
//    public void addUserName(String userName){
//        this.allUsers.add(userName);
//    }
//    public ArrayList<String> getAllUsers(){
//        return this.allUsers;
//    }
}
