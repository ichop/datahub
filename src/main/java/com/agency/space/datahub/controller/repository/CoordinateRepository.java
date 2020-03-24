package com.agency.space.datahub.controller.repository;

import com.agency.space.datahub.controller.model.Coordinate;
import org.springframework.data.repository.CrudRepository;

public interface CoordinateRepository extends CrudRepository<Coordinate, Long> {
}
