package org.example.planes.service;

import org.example.planes.core.dto.Flight;
import org.example.planes.core.dto.FlightFilter;
import org.example.planes.core.dto.Pageable;
import org.example.planes.dao.api.IFlightDao;
import org.example.planes.dao.entity.FlightEntity;
import org.example.planes.service.api.IFlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService implements IFlightService {
    private final IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }


    @Override
    public List<Flight> getAll() {
        return flightDao.getAll().stream().map(
                flightEntity -> new Flight(
                        flightEntity.getFlightId(),
                        flightEntity.getFlightNo(),
                        flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledArrival(),
                        flightEntity.getDepartureAirport(),
                        flightEntity.getArrivalAirport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraftCode(),
                        flightEntity.getActualDeparture(),
                        flightEntity.getActualArrival()
                        )).collect(Collectors.toList()
        );
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return flightDao.getPage(pageable).stream().map(
                flightEntity -> new Flight(
                        flightEntity.getFlightId(),
                        flightEntity.getFlightNo(),
                        flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledArrival(),
                        flightEntity.getDepartureAirport(),
                        flightEntity.getArrivalAirport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraftCode(),
                        flightEntity.getActualDeparture(),
                        flightEntity.getActualArrival()
                )).collect(Collectors.toList()
        );
    }

    @Override
    public List<Flight> getPage(FlightFilter flightFilter, Pageable pageable) {
        return flightDao.getPage(flightFilter, pageable).stream().map(
                flightEntity -> new Flight(
                        flightEntity.getFlightId(),
                        flightEntity.getFlightNo(),
                        flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledArrival(),
                        flightEntity.getDepartureAirport(),
                        flightEntity.getArrivalAirport(),
                        flightEntity.getStatus(),
                        flightEntity.getAircraftCode(),
                        flightEntity.getActualDeparture(),
                        flightEntity.getActualArrival()
                )).collect(Collectors.toList()
        );
    }
}
