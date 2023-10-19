package org.example.planes.service.factory;

import org.example.planes.dao.Factory.AirportDaoFactory;
import org.example.planes.service.AirportService;
import org.example.planes.service.api.IAirportService;

public class AirportServiceFactory {
    private volatile static AirportService instance;
    private AirportServiceFactory(){}

    public static IAirportService getInstance(){
        if(instance == null){
            synchronized (AircraftServiceFactory.class){
                if (instance == null){
                    instance = new AirportService(AirportDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
