package org.mickysisay.pictionary.controllers;


import org.mickysisay.pictionary.models.Allgames;
import org.mickysisay.pictionary.models.Exchangepixel;
import org.mickysisay.pictionary.models.Namesofusers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class Homepagecontroller {
    private static Allgames allgame = new Allgames();
    private static String url;
    private static String all="";
    //contains all the pixels url and all separated by "//"
    private static HashMap<String, Exchangepixel> containPixels= new HashMap<>();
    @RequestMapping(value = "" ,method= RequestMethod.GET )

    public static String helloController(Model model)
    {
        return "index";
     }
     @RequestMapping(value = "/create" , method= RequestMethod.GET )
     public static String createGetGame(){
        return "create";
     }
     @RequestMapping(value = "/create", method= RequestMethod.POST )
     public static String createGame(Model model,@RequestParam (value = "gameName") String gameName,@RequestParam (value = "userName") String userName){
           System.out.println(gameName.isEmpty() + " "+ userName+" "+ allgame.gameExists(gameName));
        if(allgame.gameExists(gameName) || gameName.isEmpty() || userName.isEmpty()) {

            model.addAttribute("error","sorry game name exists");
            return "create";
        }else{
            System.out.println("ok");
            allgame.addGame(gameName);
            //first game name then user name
            Namesofusers.addUser(gameName,userName);
            containPixels.put(gameName,new Exchangepixel());
            return "redirect:/"+gameName+"/host";
        }
     }
     @RequestMapping(value = "/join")
     public static String joinGame(Model model){
        model.addAttribute("allgames",allgame.getGames());

         return "join";
     }
    @RequestMapping(value = "/{gamename}/host" ,method= RequestMethod.GET )

    public static String hostController(Model model, @PathVariable String gamename){
        if(allgame.gameExists(gamename)){

            model.addAttribute("allUsers",Namesofusers.getAllUsers(gamename));
            model.addAttribute("gamename",gamename);
            //creates pixel transmission
            return "host.html";
        }else{
            return "redirect:/create";
        }

    }
    @RequestMapping(value = "{gamename}/guess" ,method= RequestMethod.GET )

    public static String guessController(Model model,@PathVariable String gamename,@RequestParam String userName){
        model.addAttribute("all",all);
        if(allgame.gameExists(gamename)){

            Namesofusers.addUser(gamename,userName);
            model.addAttribute("allUsers",Namesofusers.getAllUsers(gamename));
            model.addAttribute("gamename",gamename);
            return "guess.html";
        }else {
            return "redirect:/join";
        }
    }

    @RequestMapping(value ="/hellos",method=RequestMethod.GET)
    public static String changeController(Model model){

        return "fragments :: table1";
    }
    @RequestMapping(value ="{gamename}/imagesave",method=RequestMethod.GET)
    @ResponseBody
    public static String imageController(Model model,@PathVariable String gamename){
       // model.addAttribute("hello",hello);
        return containPixels.get(gamename).getUrl();
        //return url;
    }
    @RequestMapping(value ="{gamename}/imagesave",method=RequestMethod.POST)
    @ResponseBody
    public static String imagePostController(Model model,@RequestParam(value = "arrays") String arr,@PathVariable String gamename){
        // model.addAttribute("hello",hello);
        //gets object
        Exchangepixel allGame= containPixels.get(gamename);
        //changes value of all in object
        allGame.setAll(allGame.getAll()+ " "+arr);
        //changes value of url
        allGame.setUrl(arr);
        //puts it back
        containPixels.put(gamename,allGame);

//        all=all+" "+arr;
//        url = arr;
       return "url";
    }
}
