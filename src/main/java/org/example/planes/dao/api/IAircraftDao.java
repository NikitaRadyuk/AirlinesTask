package org.example.planes.dao.api;

import org.example.planes.dao.entity.AircraftEntity;

import java.util.List;

public interface IAircraftDao {
    List<AircraftEntity> getAll();
}
