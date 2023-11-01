package org.example.planes.service;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.dao.api.IFlightDao;
import org.example.planes.service.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {
    private final IFlightDao dao;

    public FlightService(IFlightDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Flight> getAll() {
        return this.dao.getAll();
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return this.dao.getPage(pageable);
    }

    @Override
    public List<Flight> getPage(FlightFilter filter, Pageable pageable) {

        return this.dao.getPage(filter, pageable);
    }
}
