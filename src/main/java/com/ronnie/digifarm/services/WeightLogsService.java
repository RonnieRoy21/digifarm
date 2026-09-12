package com.ronnie.digifarm.services;

import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.models.WeightLogs;
import com.ronnie.digifarm.repository.WeightLogsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightLogsService {

    private final WeightLogsRepository weight_repo;

    public WeightLogsService(WeightLogsRepository weightLogsRepository){
        this.weight_repo = weightLogsRepository;
    }

    public ResponseEntity<?> addWeightLog(WeightLogs log,List<WeightLogs>logs){
        if (log == null){
            return ResponseEntity.ofNullable(new ResponseModel("Error Occurred", null, null, "Empty Request Body"));
        }
        try{
            if (!logs.isEmpty()){
                weight_repo.saveAll(logs);
            }else{
            weight_repo.save(log);
            }
            return ResponseEntity.ok(new ResponseModel("Weight Log(s) Added", null, null, null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ", null, null, e.getMessage()));
        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ", null, null, e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ", null, null, e.getMessage()));
        }
    }

    public ResponseEntity<?> getWeightLog(int id){
        try{
            Optional<WeightLogs> log = weight_repo.findById(id);
            if (log.isEmpty()){
                return ResponseEntity.ok(new ResponseModel("No Such Record Found", log, null, null));
            }
            return ResponseEntity.ok(new ResponseModel("Fetch Success", log, null, null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ", null, null, e.getMessage()));
        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ", null, null, e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ", null, null, e.getMessage()));
        }
    }

    public ResponseEntity<?> getAllWeightLogs(){
        try {
            List<WeightLogs> logs = weight_repo.findAll();
            return ResponseEntity.ok(new ResponseModel("Fetch Success", null, logs, null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ", null, null, e.getMessage()));
        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ", null, null, e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ", null, null, e.getMessage()));
        }
    }

    public ResponseEntity<?> deleteByWeightLogId(int id){
        try {
            weight_repo.deleteById(id);
            return ResponseEntity.ok(new ResponseModel("Delete Success", null, null, null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ", null, null, e.getMessage()));
        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ", null, null, e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ", null, null, e.getMessage()));
        }
    }

    public ResponseEntity<?> deleteAllWeightLogs(){
        try {
            weight_repo.deleteAll();
            return ResponseEntity.ok(new ResponseModel("Delete All Success", null, null, null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ", null, null, e.getMessage()));
        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ", null, null, e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ", null, null, e.getMessage()));
        }
    }
}
