package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String url) {
        this.trainerServiceUrl = url;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        Trainer[] trainers = restTemplate.getForObject(trainerServiceUrl + "/trainers/", Trainer[].class);
        return new ArrayList<>(Arrays.asList(trainers));
    }

    public Trainer getTrainer(String name) {
        return restTemplate.getForObject(trainerServiceUrl + "/trainers/" + name, Trainer.class);
    }

    public Trainer createTrainer(Trainer trainer) {
        return restTemplate.postForObject(trainerServiceUrl + "/trainers/", trainer, Trainer.class);
    }

    public void deleteTrainer(String name) {
        restTemplate.delete(trainerServiceUrl + "/trainers/" + name);
    }

    public Trainer updateTrainer(String name, Trainer trainer) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Trainer> request = new HttpEntity<>(trainer, headers);
        restTemplate.exchange(trainerServiceUrl + "/trainers/" + name, HttpMethod.PUT, request, Trainer.class);

        return restTemplate.getForObject(trainerServiceUrl + "/trainers/" + name, Trainer.class);
    }
}
