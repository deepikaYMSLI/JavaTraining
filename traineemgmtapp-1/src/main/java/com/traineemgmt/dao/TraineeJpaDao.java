package com.traineemgmt.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.traineemgmt.entities.Trainee;
import com.traineemgmt.exception.TraineeDataAccessException;

@Repository
@ConditionalOnProperty(
	    name = "trainee.dao.type",
	    havingValue = "jpa"
	)
public class TraineeJpaDao implements TraineeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addTrainee(Trainee trainee) {
        try {
            em.persist(trainee);
        } catch (Exception e) {
            throw new TraineeDataAccessException("Error adding trainee via JPA", e);
        }
    }

    @Override
    public Trainee findById(int traineeId) {
        try {
            Trainee trainee = em.find(Trainee.class, traineeId);
            if (trainee == null) {
                throw new TraineeDataAccessException("Trainee not found via JPA", null);
            }
            return trainee;
        } catch (Exception e) {
            throw new TraineeDataAccessException("Error fetching trainee via JPA", e);
        }
    }
}

