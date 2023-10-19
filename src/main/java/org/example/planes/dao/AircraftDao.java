package org.example.planes.dao;

import org.example.planes.core.dto.Aircraft;
import org.example.planes.dao.api.IAircraftDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AircraftDao implements IAircraftDao {
    public static final String GET_ALL_PLANES = "SELECT aircraft_code, model, range FROM bookings.aircrafts_data;";
    private DataSource dataSource;

    public AircraftDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Aircraft> getAll(){
        List<Aircraft> aircrafts = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stm = conn.prepareStatement(GET_ALL_PLANES);
            ResultSet rs = stm.executeQuery();
        ) {
            while (rs.next()){
                Aircraft aircraft = new Aircraft();
                aircraft.setAircraftCode(rs.getString("aircraft_code"));
                aircraft.setModel(rs.getString("model"));
                aircraft.setRange(rs.getInt("range"));

                aircrafts.add(aircraft);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получения информации о самолётах из БД", e);
        }
        return aircrafts;
    }
}
