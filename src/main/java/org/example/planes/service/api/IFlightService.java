package org.example.planes.service.api;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;

import java.util.List;

public interface IFlightService {
    List<Flight> getAll();
    List<Flight> getPage(Pageable pageable);
    List<Flight> getPage(FlightFilter flightFilter, Pageable pageable);
}
