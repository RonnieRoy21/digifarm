package com.ronnie.digifarm.controllers;


import com.ronnie.digifarm.models.HealthLogs;
import com.ronnie.digifarm.models.InventoryTransactions;
import com.ronnie.digifarm.services.InventoryTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class InventoryTransactionController {
    InventoryTransactionService trans_service;

    public InventoryTransactionController(InventoryTransactionService inventoryTransactionService){
        this.trans_service=inventoryTransactionService;
    }


    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllTransactionLogs(){
        return trans_service.processRequest("get",null,null);
    }


    @PostMapping("/addLog")
    public ResponseEntity<?> addTransactionLog(@Validated @RequestBody InventoryTransactions log){
        return trans_service.processRequest("insert single",log,null);
    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> addTransactionLogs(@Validated @RequestBody List<InventoryTransactions> logs){
        return trans_service.processRequest("insert many",null,logs);
    }

    @PutMapping("/updateLog")
    public ResponseEntity<?> updateTransactionLog(@Validated @RequestBody InventoryTransactions log){
        return trans_service.processRequest("edit",log,null);
    }


    @DeleteMapping("/deleteLog")
    public ResponseEntity<?> deleteTransaction(@Validated @PathVariable InventoryTransactions log){
        return trans_service.processRequest("delete",log,null);
    }

}
