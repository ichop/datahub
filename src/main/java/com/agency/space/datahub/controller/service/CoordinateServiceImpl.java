package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Coordinate;
import com.agency.space.datahub.controller.repository.CoordinateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateServiceImpl implements CoordinateService {
    CoordinateRepository coordinateRepository;

    public CoordinateServiceImpl(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public Coordinate getById(Long id) {
        return coordinateRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Coordinate coordinate) {
    coordinateRepository.save(coordinate);
    }

    @Override
    public void delete(Long id) {
        coordinateRepository.deleteById(id);
    }

}
