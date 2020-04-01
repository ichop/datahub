package com.agency.space.datahub.rest;

import com.agency.space.datahub.model.Mission;
import com.agency.space.datahub.service.MissionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mission> getMission(@PathVariable("id") Long missionId) {
        if (missionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Mission mission = this.missionService.getById(missionId);

        if (mission == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mission> saveMission(@RequestBody @Valid Mission mission) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (mission == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.missionService.save(mission);
        return new ResponseEntity<>(mission, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mission> updateMission(@RequestBody @Valid Mission mission) {
        HttpHeaders headers = new HttpHeaders();

        if (mission == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.missionService.save(mission);
        return new ResponseEntity<>(mission, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mission> deleteMission(@PathVariable("id") Long missionId) {
        Mission mission = this.missionService.getById(missionId);
        if (mission == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.missionService.delete(missionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Mission>> getAllMissions() {
        List<Mission> missions = this.missionService.getAll();

        if (missions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(missions, HttpStatus.OK);
    }
}
