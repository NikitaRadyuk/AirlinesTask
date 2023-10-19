package org.example.planes.dao.api;

import org.example.planes.core.dto.Aircraft;

import java.util.List;

public interface IAircraftDao {
    List<Aircraft> getAll();
}
