package com.trainee.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("traineePU");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

