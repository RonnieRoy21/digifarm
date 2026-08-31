package com.ronnie.digifarm.controllers;

import com.ronnie.digifarm.models.Expenses;
import com.ronnie.digifarm.services.ExpensesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    ExpensesService exp_service;
    public ExpensesController(ExpensesService expensesService){
        this.exp_service=expensesService;

    }

    //add expense
    @PostMapping("/addLog")
    public ResponseEntity<?> addExpense(@Validated @RequestBody Expenses exp){
        return exp_service.addSingleExpense(exp);
    }


    //read expenses
    @GetMapping("/getAllLogs")
    public ResponseEntity<?> getAllExpenses(){
        return exp_service.retrieveExpenses();
    }


    //delete expenses
    @DeleteMapping("/deleteAllLogs")
    public ResponseEntity<?> addExpense(){
        return exp_service.deleteAllExpense();
    }
    //delete expenses by id
     @DeleteMapping("/deleteLogById/{id}")
        public ResponseEntity<?> addExpense(@Validated @PathVariable int id){
            return exp_service.deleteExpenseById(id);
        }

}
