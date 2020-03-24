package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Mission;
import com.agency.space.datahub.controller.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionServiceImpl implements MissionService{


    MissionRepository missionRepository;

    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public Mission getById(Long id) {
      return   missionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Mission mission) {
    missionRepository.save(mission);
    }


    @Override
    public void delete(Long id) {
    missionRepository.deleteById(id);
    }

    @Override
    public List<Mission> getAll() {
        return (List<Mission>) missionRepository.findAll();
    }

}
