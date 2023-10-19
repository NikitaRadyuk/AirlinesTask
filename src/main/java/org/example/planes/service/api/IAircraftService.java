package org.example.planes.service.api;

import org.example.planes.core.dto.Aircraft;

import java.util.List;

public interface IAircraftService {
    List<Aircraft> getAll();
}
