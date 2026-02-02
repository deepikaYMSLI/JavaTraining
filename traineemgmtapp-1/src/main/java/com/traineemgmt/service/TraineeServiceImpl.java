package com.traineemgmt.service;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.traineemgmt.dao.TraineeDao;
import com.traineemgmt.entities.Trainee;
import com.traineemgmt.exception.ResourceNotFoundException;
import com.traineemgmt.exception.TraineeDataAccessException;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeDao traineeDao;

    public TraineeServiceImpl(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }
    @Transactional
    @Override
    public void addTrainee(Trainee trainee) {
        traineeDao.addTrainee(trainee);
    }

    @Override
    public Trainee getById(int id) {
    	try {
            return traineeDao.findById(id);
        } catch (TraineeDataAccessException e) {
            throw new ResourceNotFoundException("Trainee not found with id " + id);
        }
}
}
