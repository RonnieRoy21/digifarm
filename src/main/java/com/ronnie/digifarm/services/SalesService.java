package com.ronnie.digifarm.services;

import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.models.Sales;
import com.ronnie.digifarm.repository.SalesRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {


        private final SalesRepository sales_repo;

        public SalesService(SalesRepository salesRepository){
            this.sales_repo=salesRepository;
        }

        public ResponseEntity<?> processRequest(String action , Sales single, List<Sales> body,Integer deleteId){
            try{
                if (action.trim().isEmpty()){
                    return ResponseEntity.badRequest().body(new ResponseModel("Invalid Action",null,null,null));
                }
                return switch ( action.toLowerCase()) {
                    case "insert single" -> {
                        if(single == null){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        sales_repo.save(single);
                        yield ResponseEntity.ok(new ResponseModel("Added Sale ", null, null, null));
                    }
                    case "insert many" -> {
                        if(body.isEmpty()){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        sales_repo.saveAll(body);
                        yield ResponseEntity.ok(new ResponseModel("Added Sales ", null, null, null));
                    }
                    case "edit" -> {
                        if(single == null){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        sales_repo.save(single);
                        yield ResponseEntity.ok(new ResponseModel("Updated Sale ", null, null, null));
                    }
                    case "delete" -> {
                        sales_repo.deleteById(deleteId);
                        yield ResponseEntity.ok(new ResponseModel("Deleted Sale ", null, null, null));
                    }
                    case "get" -> {
                        List<Sales> logs =    sales_repo.findAll();
                        yield ResponseEntity.ok(new ResponseModel("Fetched Sales ", null, logs, null));
                    }
                    default -> ResponseEntity.ok(new ResponseModel("Bad Request.No Action Performed", null, null, null));
                };
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


