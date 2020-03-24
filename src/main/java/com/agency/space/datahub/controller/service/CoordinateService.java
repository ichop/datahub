package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Coordinate;


public interface CoordinateService {
    Coordinate getById(Long id);

    void save(Coordinate coordinate);

    void delete(Long id);
}
