package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Mission;

import java.util.List;

public interface MissionService {
    Mission getById(Long id);

    void save(Mission mission);

    void delete(Long id);

    List<Mission> getAll();
}
