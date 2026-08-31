package com.ronnie.digifarm.controllers;

import com.ronnie.digifarm.models.Flocks;
import com.ronnie.digifarm.repository.FlocksRepository;
import com.ronnie.digifarm.services.FlockService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flock")
public class FlockController {

    FlockService flock_service;

    public FlockController(FlockService flockService){
        this.flock_service=flockService;

    }

    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllFlockRecords(){
        return flock_service.getAllFlocks();
    }

    @GetMapping("/getLogById/{flockId}")
    public ResponseEntity<?> getByFlockId(@Validated @PathVariable int flockId){
        return flock_service.getFlock(flockId);
    }

    @PostMapping("/addLog")
    public ResponseEntity<?> addFlock(@Validated @RequestBody Flocks flock){
        return flock_service.addFlock(flock);
    }

    @DeleteMapping("/deleteLogById/{flockId}")
    public ResponseEntity<?> deleteByFlockId(@Validated @PathVariable int flockId){
        return flock_service.deleteByFlockId(flockId);
    }

    @DeleteMapping("/deleteAllLogs")
    public ResponseEntity<?> deleteAllFlock(){
        return flock_service.deleteAllFlocks();
    }
}
