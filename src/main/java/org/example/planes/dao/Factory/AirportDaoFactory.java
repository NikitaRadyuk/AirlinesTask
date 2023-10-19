package org.example.planes.dao.Factory;

import org.example.planes.dao.AirportDao;
import org.example.planes.dao.DataSource.DataSourceFactory;
import org.example.planes.dao.api.IAirportDao;

public class AirportDaoFactory {
    private volatile static AirportDao instance;
    private AirportDaoFactory(){
    }

    public static IAirportDao getInstance(){
        if (instance == null) {
            synchronized (AirportDaoFactory.class){
                if (instance == null){
                    instance = new AirportDao(DataSourceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
