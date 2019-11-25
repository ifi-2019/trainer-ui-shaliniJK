package com.ifi.trainer_ui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer(@RequestParam String trainerName){
        var modelAndView = new ModelAndView("register");

        modelAndView.addObject("name", trainerName);

        return modelAndView;
    }

}
