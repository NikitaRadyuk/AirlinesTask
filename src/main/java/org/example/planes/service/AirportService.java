package org.example.planes.service;

import org.example.planes.core.dto.Airport;
import org.example.planes.dao.api.IAirportDao;
import org.example.planes.service.api.IAirportService;

import java.util.List;
import java.util.stream.Collectors;

public class AirportService implements IAirportService {
    private final IAirportDao airportDao;

    public AirportService(IAirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public List<Airport> getAll() {
        return airportDao.getAll().stream().map(airportEntity -> new Airport(
                airportEntity.getAirportCode(),
                airportEntity.getAirportName(),
                airportEntity.getCity(),
                airportEntity.getCoordinates(),
                airportEntity.getTimezone())).collect(Collectors.toList());
    }
}
