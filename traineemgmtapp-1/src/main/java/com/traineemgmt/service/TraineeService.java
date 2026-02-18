package com.traineemgmt.service;

import com.traineemgmt.entities.Trainee;

public interface TraineeService {
    void addTrainee(Trainee trainee);
    Trainee getById(int id);
}



