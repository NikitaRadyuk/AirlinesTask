package org.example.planes.dao.Factory;

import org.example.planes.dao.DataSource.DataSourceFactory;
import org.example.planes.dao.FlightDao;
import org.example.planes.dao.api.IFlightDao;

public class FlightDaoFactory {
    private volatile static FlightDao instance;
    private FlightDaoFactory(){
    }

    public IFlightDao getInstance(){
        if (instance == null) {
            synchronized (FlightDaoFactory.class){
                if (instance == null){
                    instance = new FlightDao(DataSourceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
