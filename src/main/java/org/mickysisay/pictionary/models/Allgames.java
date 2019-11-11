package org.mickysisay.pictionary.models;

import java.util.ArrayList;

public class Allgames {
    private ArrayList<String> games = new ArrayList<>();
    public String addGame(String name){
        if(games.contains(name)){
          return "game name already exists";
        }else{
            games.add(name);
            return "success";
        }
    }
    public String removeGame(String name){
        if(games.contains(name)){
            games.remove(games.indexOf(name));
            return "success";
        }else{
            return "game requested doesn't";
        }
    }
    public boolean gameExists(String name){
        return games.contains(name);
    }
    public ArrayList<String> getGames(){
        return games;
    }
}
