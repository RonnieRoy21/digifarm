package com.ronnie.digifarm.controllers;


import com.ronnie.digifarm.models.InventoryItems;
import com.ronnie.digifarm.services.InventoryItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryItemsController {
InventoryItemsService inv_item_service;

public InventoryItemsController(InventoryItemsService inventoryItemsService){
    this.inv_item_service=inventoryItemsService;
}


    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllHealthLogs(){
        return inv_item_service.processRequest("get",null,null,null);
    }


    @PostMapping("/addLog")
    public ResponseEntity<?> addHealthLog(@Validated @RequestBody InventoryItems log){
        return inv_item_service.processRequest("insert single",log,null,null);
    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> addHealthLogs(@Validated @RequestBody List<InventoryItems> logs){
        return inv_item_service.processRequest("insert many",null,logs,null);
    }

    @PutMapping("/updateLog")
    public ResponseEntity<?> updateHealthLog(@Validated @RequestBody InventoryItems log){
        return inv_item_service.processRequest("edit",log,null,null);
    }


    @DeleteMapping("/deleteLogById/{id}")
    public ResponseEntity<?> deleteByFlockId(@Validated @PathVariable int id){
        return inv_item_service.processRequest("delete",null,null,id);
    }


}
