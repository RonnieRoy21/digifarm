package com.ronnie.digifarm.controllers;

import com.ronnie.digifarm.models.MortalityLogs;
import com.ronnie.digifarm.services.MortalityLogsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mortality")
@CrossOrigin
public class MortalityLogsController {

    MortalityLogsService mortality_service;

    public MortalityLogsController(MortalityLogsService morta){
        this.mortality_service=morta;
    }

    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getMortalityLogs(){
        return mortality_service.processRequest("get",null,null);

    }
    @PostMapping("/addLog")
    public ResponseEntity<?> addMortalityLog(MortalityLogs log){
        return mortality_service.processRequest("insert single",log,null);

    }
    @PostMapping("/addLogs")
    public ResponseEntity<?> addMortalityLogs(List<MortalityLogs> logs){
        return mortality_service.processRequest("insert many",null,logs);

    }


}
