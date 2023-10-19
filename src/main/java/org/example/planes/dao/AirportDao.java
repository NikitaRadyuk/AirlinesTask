package org.example.planes.dao;

import org.example.planes.core.dto.Airport;
import org.example.planes.dao.api.IAirportDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao implements IAirportDao {
    public static final String GET_ALL_AIRPORTS = "SELECT airport_code, airport_name, city, coordinates, timezone FROM bookings.airports_data;";
    private DataSource dataSource;

    public AirportDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Airport> getAll(){
        List<Airport> airports = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement st = connection.prepareStatement(GET_ALL_AIRPORTS);
                ResultSet rs = st.executeQuery();
                ) {
            while(rs.next()){
                Airport airport = new Airport();
                airport.setAirportCode(rs.getString("airport_code"));
                airport.setAirportName(rs.getString("airport_name"));
                airport.setCity(rs.getString("city"));
                airport.setPoint(rs.getString("coordinates"));
                airport.setTimezone(rs.getString("timezone"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при получении информации о всех аэропортах",e);
        }
        return airports;
    }
}
