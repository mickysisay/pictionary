package org.mickysisay.pictionary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class Homepagecontroller {
    static HashMap<String,String> hello = new HashMap<>();
    static {
        hello.put("micky","sisay");
        hello.put("robel","ambachew");
    }
    @RequestMapping(value = "/hello" ,method= RequestMethod.GET )

    public static String helloController(Model model){
        model.addAttribute("hello",hello);
        return "index";
     }
    @RequestMapping(value ="/hello",method=RequestMethod.POST)
    public static String addController(@RequestParam String firstName , @RequestParam String lastName){
      hello.put(firstName,lastName);
        return "redirect:/hello";
    }
    @RequestMapping(value ="/hellos",method=RequestMethod.GET)
    public static String changeController(Model model){
        model.addAttribute("hello",hello);
        return "fragments :: table1";
    }
}
