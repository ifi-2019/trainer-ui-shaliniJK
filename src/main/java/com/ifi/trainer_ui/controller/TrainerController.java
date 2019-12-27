package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public ModelAndView getAllTrainers(){
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers", trainerService.getAllTrainers());
        return modelAndView;
    }

    @GetMapping("/trainers/{name}")
    public ModelAndView getTrainer(@PathVariable String name){
        return new ModelAndView("trainer", "trainer", trainerService.getTrainer(name));
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        Trainer trainer = trainerService.getTrainer(user.getUsername());
        if  (trainer == null) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return null;
        }

        var modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile", trainer);
        return modelAndView;
    }

    @PostMapping("/trainers")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.createTrainer(trainer);
    }

    @PutMapping("/trainers/{name}")
    public Trainer updateTrainer(@PathVariable String name, @RequestBody Trainer trainerDetails) {
        return trainerService.updateTrainer(name, trainerDetails);
    }

    @DeleteMapping("/trainers/{name}")
    public void deleteTrainer(@PathVariable String name){
        trainerService.deleteTrainer(name);
    }
}
