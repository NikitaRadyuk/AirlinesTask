package org.example.planes.service;

import org.example.planes.core.dto.Aircraft;
import org.example.planes.dao.api.IAircraftDao;
import org.example.planes.service.api.IAircraftService;

import java.util.List;
import java.util.stream.Collectors;

public class AircraftService implements IAircraftService {
        private final IAircraftDao aircraftDao;

    public AircraftService(IAircraftDao aircraftDao) {
        this.aircraftDao = aircraftDao;
    }

    @Override
    public List<Aircraft> getAll() {
        return aircraftDao.getAll().stream().map(aircraftEntity -> new Aircraft(
                aircraftEntity.getAircraftCode(),
                aircraftEntity.getModel(),
                aircraftEntity.getRange())).collect(Collectors.toList());
    }
}
