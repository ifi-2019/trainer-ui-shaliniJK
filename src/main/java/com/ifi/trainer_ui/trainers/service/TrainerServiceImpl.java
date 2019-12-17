package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    @Autowired
    public TrainerServiceImpl() {

    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Iterable<Trainer> getAllTrainers() {
        return null;
    }

    public Trainer getTrainer(String name) {
        return null;
    }

    public Trainer createTrainer(Trainer trainer) {
        return null;
    }

    public void deleteTrainer(String name) {}

}
