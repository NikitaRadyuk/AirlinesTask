package org.example.planes.dao.api;

import org.example.planes.dao.entity.AirportEntity;

import java.util.List;

public interface IAirportDao {
    List<AirportEntity> getAll();
}
