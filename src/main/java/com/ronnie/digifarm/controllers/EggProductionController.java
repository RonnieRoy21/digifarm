package com.ronnie.digifarm.controllers;


import com.ronnie.digifarm.models.EggsProductionLogs;
import com.ronnie.digifarm.services.EggsProductionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggs")
@CrossOrigin
public class EggProductionController {

    EggsProductionService egg_service;
    public EggProductionController(EggsProductionService eggsProductionService){
        this.egg_service= eggsProductionService;
    }
@GetMapping("/getLogs")
    public ResponseEntity<?> getAllRecords(){
        return egg_service.getAllRecords();

}
@PostMapping("/addLog")
    public ResponseEntity<?> addSingleRecord(@Validated @RequestBody EggsProductionLogs rec){
        return egg_service.addEggRecord(rec);

}
@PostMapping("/addLogs")
    public ResponseEntity<?> addManyRecords(@Validated @RequestBody List<EggsProductionLogs> recs){
        return egg_service.addEggRecords(recs);
}
@DeleteMapping("/deleteLogById/{id}")
    public ResponseEntity<?> deleteEggRecordById(@Validated @PathVariable int id){
        return egg_service.deleteRecord(id);
}

}
