package com.agency.space.datahub.service;

import com.agency.space.datahub.model.Mission;

import java.util.List;

public interface MissionService {
    Mission getById(Long id);

    void save(Mission mission);

    void delete(Long id);

    List<Mission> getAll();
}
