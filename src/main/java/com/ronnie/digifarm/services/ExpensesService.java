package com.ronnie.digifarm.services;


import com.ronnie.digifarm.models.Expenses;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.ExpensesRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    ExpensesRepository exp_repo;
    public ExpensesService (ExpensesRepository expensesRepository){
        this.exp_repo=expensesRepository;
    }

    public ResponseEntity<?> addSingleExpense(Expenses exp) {
        try{
            exp_repo.save(exp);
            return ResponseEntity.ok(new ResponseModel("Expense Added",null,null,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }

    public ResponseEntity<?> retrieveExpenses() {
        try{
            List<Expenses> expenses=exp_repo.findAll();
            return ResponseEntity.ok(new ResponseModel("Fetch Success",null,expenses,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }

    public ResponseEntity<?> deleteAllExpense() {
        try{
            exp_repo.deleteAll();
            return ResponseEntity.ok(new ResponseModel("Delete Success",null,null,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }

    public ResponseEntity<?> deleteExpenseById(int id) {
        try{
            exp_repo.deleteById(id);
            return ResponseEntity.ok(new ResponseModel("Deleted Single Expense",null,null,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }

}
