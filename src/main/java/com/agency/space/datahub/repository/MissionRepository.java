package com.agency.space.datahub.repository;

import com.agency.space.datahub.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MissionRepository extends JpaRepository<Mission, Long> {
}
