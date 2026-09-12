package com.ronnie.digifarm.controllers;
import com.ronnie.digifarm.models.HealthLogs;
import com.ronnie.digifarm.services.HealthLogsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
@CrossOrigin
public class HealthLogsController {
    HealthLogsService health_service;

    public HealthLogsController(HealthLogsService healthLogsService){
        this.health_service=healthLogsService;

    }

    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllHealthLogs(){
        return health_service.processRequest("get",null,null,null);
    }


    @PostMapping("/addLog")
    public ResponseEntity<?> addHealthLog(@Validated @RequestBody HealthLogs log){
        return health_service.processRequest("insert single",log,null,null);
    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> addHealthLogs(@Validated @RequestBody List<HealthLogs> logs){
        return health_service.processRequest("insert many",null,logs,null);
    }

    @PutMapping("/updateLog")
    public ResponseEntity<?> updateHealthLog(@Validated @RequestBody HealthLogs log){
        return health_service.processRequest("edit",log,null,null);
    }


    @DeleteMapping("/deleteLogById/{id}")
    public ResponseEntity<?> deleteByFlockId(@Validated @PathVariable int id){
        return health_service.processRequest("delete",null,null,id);
    }

}
