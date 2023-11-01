package org.example.planes.dao.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DataSourceFactory {
    private static ComboPooledDataSource ds;

    static {
        ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new IllegalStateException("Ошибка инициализации драйвера БД", e);
        }
        ds.setJdbcUrl("jdbc:postgresql://db:5432/demo");
        ds.setUser("postgres");
        ds.setPassword("12345678");
    }
    public static DataSource getInstance(){
        return ds;
    }
}
