package org.example.planes.dao.api;

import org.example.planes.core.dto.Airport;

import java.util.List;

public interface IAirportDao {
    List<Airport> getAll();
}
