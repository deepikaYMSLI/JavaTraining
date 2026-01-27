package com.trainee.dao;

import com.trainee.dto.Trainee;
import com.trainee.exceptions.DaoException;

public interface TraineeDao {

    void addTrainee(Trainee trainee) throws DaoException;

    Trainee findTraineeById(int traineeId) throws DaoException;
}
