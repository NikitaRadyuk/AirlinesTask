package org.example.planes.service.factory;

import org.example.planes.dao.Factory.FlightDaoFactory;
import org.example.planes.service.FlightService;
import org.example.planes.service.api.IFlightService;

public class FlightServiceFactory {
    private volatile static FlightService instance;

    private FlightServiceFactory(){}

    public static IFlightService getInstance(){
        if(instance == null){
            synchronized (FlightServiceFactory.class){
                if(instance == null){
                    instance = new FlightService(FlightDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
