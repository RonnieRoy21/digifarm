package com.ronnie.digifarm.services;


import com.ronnie.digifarm.models.HealthLogs;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.HealthLogsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthLogsService {

    HealthLogsRepository health_repo;
    public HealthLogsService(HealthLogsRepository healthLogsRepository){
        this .health_repo=healthLogsRepository;
    }

    public ResponseEntity<?> processRequest(String action, HealthLogs single, List<HealthLogs> body){
        try{

            return switch (action.toLowerCase()) {
                case "insert single" -> {
                    if(single == null){
                        yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                    }
                    health_repo.save(single);
                    yield ResponseEntity.ok(new ResponseModel("Added Log ", null, null, null));
                }
                case "insert many" -> {
                    if(body.isEmpty()){
                        yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                    }
                    health_repo.saveAll(body);
                    yield ResponseEntity.ok(new ResponseModel("Added Logs ", null, null, null));
                }
                case "edit" -> {
                    if(single == null){
                        yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                    }
                    health_repo.save(single);
                    yield ResponseEntity.ok(new ResponseModel("Updated Log ", null, null, null));
                }
                case "delete" -> {
                    health_repo.delete(single);
                    yield ResponseEntity.ok(new ResponseModel("Deleted Log ", null, null, null));
                }
                case "get" -> {
                    List<HealthLogs> logs = health_repo.findAll();
                    yield ResponseEntity.ok(new ResponseModel("Added Log ", null, logs, null));
                }
                default -> ResponseEntity.ok(new ResponseModel("Bad Request.No Action Performed", null, null, null));
            };
        } catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }
}
