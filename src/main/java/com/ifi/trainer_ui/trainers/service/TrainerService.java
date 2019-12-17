package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.trainers.bo.Trainer;

import java.util.List;

public interface TrainerService {

    Iterable<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    void deleteTrainer(String name);

}
