package org.example.planes.service;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.dao.api.IFlightDao;
import org.example.planes.service.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {
    private final IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }


    @Override
    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return flightDao.getPage(pageable);
    }

    @Override
    public List<Flight> getPage(FlightFilter flightFilter, Pageable pageable) {
        return getPage(flightFilter, pageable);
    }
}
