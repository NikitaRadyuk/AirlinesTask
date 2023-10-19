package org.example.planes.dao.DataSource;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFFactory {
    private final static EntityManagerFactory instance;

    static{
        instance = Persistence.createEntityManagerFactory("planes");
    }

    public static EntityManagerFactory getInstance(){
        return instance;
    }
}
