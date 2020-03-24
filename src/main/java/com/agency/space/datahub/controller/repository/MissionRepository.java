package com.agency.space.datahub.controller.repository;

import com.agency.space.datahub.controller.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends CrudRepository<Mission, Long> {
}
