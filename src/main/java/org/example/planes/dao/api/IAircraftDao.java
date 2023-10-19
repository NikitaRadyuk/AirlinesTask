package org.example.planes.dao.api;

import org.example.planes.core.dto.Aircraft;
import org.example.planes.dao.exception.DaoException;

import java.util.List;

public interface IAircraftDao {
    List<Aircraft> getAll() throws DaoException;
}
