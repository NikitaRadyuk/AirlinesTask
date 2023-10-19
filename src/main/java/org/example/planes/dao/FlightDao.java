package org.example.planes.dao;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.dao.api.IFlightDao;

import javax.sql.DataSource;
import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {
    public static final String GET_ALL_FLIGHT = "SELECT flight_id, flight_no, scheduled_departure, scheduled_departure_local, scheduled_arrival, scheduled_arrival_local, scheduled_duration, departure_airport, departure_airport_name, departure_city, arrival_airport, arrival_airport_name, arrival_city, status, aircraft_code, actual_departure, actual_departure_local, actual_arrival, actual_arrival_local, actual_duration FROM bookings.flights_v";
    public static final String GET_COUNT = "SELECT count(*) FROM bookings.flights";
    private DataSource datasource;

    public FlightDao(DataSource dataSource) {
        this.datasource = datasource;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_FLIGHT);
             ResultSet rs = statement.executeQuery();
        ) {
            while (rs.next()) {
                flights.add(map(rs));
            }
            return flights;
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return getPage(null, pageable);
    }

    @Override
    public List<Flight> getPage(FlightFilter flightFilter, Pageable pageable) {
        List<Object> params = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        String sql = GET_ALL_FLIGHT;

        if (flightFilter != null) {

            boolean needSeparator = false;
            if (flightFilter.getScheduledDeparture() != null) {
                if (needSeparator) {
                    builder.append(" AND");
                } else {
                    needSeparator = true;
                }
                builder.append("scheduled_departure >= ? AND scheduled_departure < ?");
                params.add(flightFilter.getScheduledDeparture());
                params.add(flightFilter.getScheduledDeparture().plusDays(1));
            }

            if (flightFilter.getScheduledArrival() != null) {
                if (needSeparator) {
                    builder.append(" AND");
                } else {
                    needSeparator = true;
                }
                builder.append("scheduled_arrival >= ? AND scheduled_arrival < ?");
                params.add(flightFilter.getScheduledArrival());
                params.add(flightFilter.getScheduledArrival().plusDays(1));
            }

            if (flightFilter.getDepartureAirport() != null) {
                if (needSeparator) {
                    builder.append(" AND");
                } else {
                    needSeparator = true;
                }
                builder.append("departure_airport = ?");
                params.add(flightFilter.getDepartureAirport());
            }

            if (flightFilter.getArrivalAirport() != null) {
                if (needSeparator) {
                    builder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                builder.append("arrival_airport = ?");
                params.add(flightFilter.getArrivalAirport());
            }

            if (flightFilter.getStatus() != null) {
                if (needSeparator) {
                    builder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                builder.append(" status = ?");
                params.add(flightFilter.getStatus());
            }

            if (builder.length() > 0) {
                builder.insert(0, " WHERE ");
                sql += builder;
            }
        }

        if (pageable != null) {
            int size = pageable.getSize();
            int page = pageable.getPage();

            sql += " LIMIT ? OFFSET ?";
            params.add(size);
            params.add(size * (page - 1));
        }

        List<Flight> flights = new ArrayList<>();
        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            int index = 1;
            for (Object param : params
            ) {
                statement.setObject(index++, param);
            }

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    flights.add(map(rs));
                }
                return flights;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    private Flight map(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(rs.getInt("flight_id"));
        flight.setFlightNo(rs.getString("flight_no"));
        flight.setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class));
        flight.setScheduledArrival(rs.getObject("scheduled_arrival", OffsetDateTime.class));
        flight.setDepartureAirport(rs.getString("departure_airport"));
        flight.setArrivalAirport(rs.getString("arrival_airport"));
        flight.setStatus(rs.getString("status"));
        flight.setAircraftCode(rs.getString("aircraft_code"));
        flight.setActualDeparture(rs.getObject("actual_departure", OffsetDateTime.class));
        flight.setActualArrival(rs.getObject("actual_arrival", OffsetDateTime.class));
        return flight;
    }

    private int count() {
        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_COUNT);
             ResultSet rs = statement.executeQuery();
        ) {
            int count = rs.getInt(1);
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка выполнения запроса", e);
        }
        return count();
    }
}