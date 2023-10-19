package org.example.planes.dao.api;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.dao.exception.DaoException;

import java.util.List;

public interface IFlightDao {
    List<Flight> getAll() throws DaoException;
    List<Flight> getPage(Pageable pageable);
    List<Flight> getPage(FlightFilter flightFilter, Pageable pageable);
}
