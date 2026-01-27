package com.trainee.dao;

import com.trainee.dto.Trainee;
import com.trainee.exceptions.DaoException;
import com.trainee.util.EmFactory;

import jakarta.persistence.EntityManager;

public class TraineeDaoHibImpl implements TraineeDao {

   
    public void addTrainee(Trainee trainee) throws DaoException {

        EntityManager em = EmFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trainee);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DaoException("Hibernate insert error", e);
        } finally {
            em.close();
        }
    }

    
    public Trainee findTraineeById(int traineeId) throws DaoException {

        EntityManager em = EmFactory.getEntityManager();
        Trainee trainee = null;

        try {
            trainee = em.find(Trainee.class, traineeId);
        } catch (Exception e) {
            throw new DaoException("Hibernate fetch error", e);
        } finally {
            em.close();
        }
        return trainee;
    }
}
