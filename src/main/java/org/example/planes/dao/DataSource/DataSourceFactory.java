package org.example.planes.dao.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

public class DataSourceFactory {
    private static DataSourceFactory instance;
    private ComboPooledDataSource ds;

    public DataSourceFactory() {
        ds = new ComboPooledDataSource();

        try {
            ds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new IllegalStateException("Ошибка инициализации драйвера БД", e);
        }
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        ds.setUser("postgres");
        ds.setPassword("12345678");
    }
    public static ComboPooledDataSource getInstance(){
        if(instance == null){
            synchronized (DataSourceFactory.class){
                instance = new DataSourceFactory();
            }
        }
        return instance.ds;
    }
}
