package com.ronnie.digifarm.services;


import com.ronnie.digifarm.models.EggsProductionLogs;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.EggsProductionRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EggsProductionService {

    EggsProductionRepository egg_repo;

    public EggsProductionService(EggsProductionRepository eggsProductionRepository){
        this.egg_repo=eggsProductionRepository;
    }

    //get all records
    public ResponseEntity <?>getAllRecords(){

       try{
           List<EggsProductionLogs> records=egg_repo.findAll();


           return ResponseEntity.ok(new ResponseModel("Fetch Success",null,records,null));
       }catch(DataIntegrityViolationException e){
           return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

       }catch(DataAccessException e){
           return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

       }
       catch (Exception e){
           return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
       }

    }


    //insert a record
  public ResponseEntity<?> addEggRecord(EggsProductionLogs log){
        try{
            egg_repo.save(log);
            return ResponseEntity.ok().body(new ResponseModel("Log Added",null,null,null));

        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

  }

  //insert a bunch of records
  public ResponseEntity<?> addEggRecords(List<EggsProductionLogs> logs){
      try{
          egg_repo.saveAll(logs);
          return ResponseEntity.ok().body(new ResponseModel("Logs saved",null,null,null));

      }catch(DataIntegrityViolationException e){
          return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

      }catch(DataAccessException e){
          return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

      }
      catch (Exception e){
          return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
      }

  }

//delete record by id
    public ResponseEntity<?> deleteRecord(int id){
        try{
            egg_repo.deleteById(id);
            return ResponseEntity.ok(new ResponseModel("Delete success",null,null,null));
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
