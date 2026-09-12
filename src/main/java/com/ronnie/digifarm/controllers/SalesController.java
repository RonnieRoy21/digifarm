package com.ronnie.digifarm.controllers;


import com.ronnie.digifarm.models.Sales;
import com.ronnie.digifarm.services.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SalesController {
    private final SalesService sale_Service;

    public SalesController(SalesService salesService){
        this.sale_Service=salesService;
    }


    @PostMapping("/addLog")
    public ResponseEntity<?> addSalesLog(Sales sale){
        return sale_Service.processRequest("insert single",sale,null,null);

    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> addSalesLogs(List<Sales> sales){
        return sale_Service.processRequest("insert many",null,sales,null);
    }


    @PutMapping("/updateLog")
    public ResponseEntity<?> updateSalesLog(Sales sale){
        return sale_Service.processRequest("edit",sale,null,null);
    }

    @DeleteMapping("/deleteLogById{id}")
    public ResponseEntity<?> deleteSalesLog(int id){
        return sale_Service.processRequest("delete",null,null,id);
    }

    @GetMapping("/getLogs")
    public ResponseEntity<?> getAllSalesLos(){
        return sale_Service.processRequest("get",null,null,null);
    }


}
