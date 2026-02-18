package com.traineemgmt.dao;

import com.traineemgmt.entities.Trainee;

//import com.traineemgmtapp.entities.Trainee;

public interface TraineeDao {
    void addTrainee(Trainee trainee);
    Trainee findById(int traineeId);
}


