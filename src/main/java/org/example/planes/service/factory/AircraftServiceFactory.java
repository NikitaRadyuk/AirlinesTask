package org.example.planes.service.factory;

import org.example.planes.dao.Factory.AircraftDaoFactory;
import org.example.planes.service.AircraftService;

public class AircraftServiceFactory {
    private volatile static AircraftService instance;

    public AircraftServiceFactory() {
    }

    public static AircraftService getInstance(){
        if(instance == null){
            synchronized (AircraftServiceFactory.class){
                if(instance == null){
                    instance = new AircraftService(AircraftDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
