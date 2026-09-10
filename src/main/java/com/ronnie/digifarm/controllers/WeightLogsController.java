package com.ronnie.digifarm.controllers;

import com.ronnie.digifarm.models.WeightLogs;
import com.ronnie.digifarm.services.WeightLogsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weight")
@CrossOrigin
public class WeightLogsController {

    WeightLogsService weight_service;

    public WeightLogsController(WeightLogsService weightLogsService){
        this.weight_service = weightLogsService;
    }

    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllWeightLogs(){
        return weight_service.getAllWeightLogs();
    }

    @GetMapping("/getLogById/{id}")
    public ResponseEntity<?> getByWeightLogId(@Validated @PathVariable int id){
        return weight_service.getWeightLog(id);
    }

    @PostMapping("/addLog")
    public ResponseEntity<?> addWeightLog(@Validated @RequestBody WeightLogs log){
        return weight_service.addWeightLog(log);
    }

    @DeleteMapping("/deleteLogById/{id}")
    public ResponseEntity<?> deleteByWeightLogId(@Validated @PathVariable int id){
        return weight_service.deleteByWeightLogId(id);
    }

    @DeleteMapping("/deleteAllLogs")
    public ResponseEntity<?> deleteAllWeightLogs(){
        return weight_service.deleteAllWeightLogs();
    }
}
