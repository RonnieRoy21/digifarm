package com.ronnie.digifarm.controllers;


import com.ronnie.digifarm.models.Sales;
import com.ronnie.digifarm.services.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    private final SalesService sale_Service;

    public SalesController(SalesService salesService){
        this.sale_Service=salesService;
    }


    @PostMapping("/addLog")
    public ResponseEntity<?> addSalesLog(Sales sale){
        return sale_Service.processRequest("insert single",sale,null);

    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> addSalesLogs(List<Sales> sales){
        return sale_Service.processRequest("insert many",null,sales);
    }


    @PutMapping("/updateLog")
    public ResponseEntity<?> updateSalesLog(Sales sale){
        return sale_Service.processRequest("edit",sale,null);
    }

    @DeleteMapping("/deleteLog")
    public ResponseEntity<?> deleteSalesLog(Sales sale){
        return sale_Service.processRequest("delete",sale,null);
    }

    @GetMapping("/getLogs")
    public ResponseEntity<?> getAllSalesLos(){
        return sale_Service.processRequest("get",null,null);
    }


}
