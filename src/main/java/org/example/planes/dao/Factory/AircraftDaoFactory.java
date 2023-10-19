package org.example.planes.dao.Factory;

import org.example.planes.dao.AircraftDao;
import org.example.planes.dao.DataSource.DataSourceFactory;
import org.example.planes.dao.api.IAircraftDao;

public class AircraftDaoFactory {
    private volatile static AircraftDao instance;
    private AircraftDaoFactory(){
    }

    public IAircraftDao getInstance(){
        if (instance == null) {
            synchronized (AircraftDaoFactory.class){
                if (instance == null){
                    instance = new AircraftDao(DataSourceFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
