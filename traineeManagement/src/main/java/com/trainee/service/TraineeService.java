package com.trainee.service;

import com.trainee.dao.TraineeDao;
import com.trainee.dao.TraineeDaoJdbcImpl;
import com.trainee.dto.Trainee;
import com.trainee.exceptions.DaoException;

public class TraineeService {

    private TraineeDao dao = new TraineeDaoJdbcImpl();

    public void addTrainee(Trainee trainee) throws DaoException {
        dao.addTrainee(trainee);
    }

    public Trainee findTraineeById(int id) throws DaoException {
        return dao.findTraineeById(id);
    }
}
