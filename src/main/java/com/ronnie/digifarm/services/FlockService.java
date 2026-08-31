package com.ronnie.digifarm.services;


import com.ronnie.digifarm.models.Flocks;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.FlocksRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlockService {

    private final FlocksRepository flock_repo;

    public FlockService(FlocksRepository flocksRepository){
        this.flock_repo=flocksRepository;
    }

    //add a new flock
    public ResponseEntity<?> addFlock(Flocks flock){
        if (flock == null){
            return ResponseEntity.ofNullable(new ResponseModel("Error Occurred",null,null,"Empty Request Body"));
        }
        try{
            flock_repo.save(flock);
            return ResponseEntity.ok(new ResponseModel("Flock Added",null,null,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }
    //access a flock record by flock id
    public ResponseEntity<?> getFlock(int flockId){
        try{
            Optional<Flocks> flock=flock_repo.findById(flockId);
            if (flock.isEmpty()){
                return ResponseEntity.ok(new ResponseModel("No Such Record Found",flock,null,null));
            }

            return ResponseEntity.ok(new ResponseModel("Fetch Success",flock,null,null));
        } catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }


    //access all flock records
    public ResponseEntity<?> getAllFlocks(){
        try {
            List<Flocks> flocks=flock_repo.findAll();
            return ResponseEntity.ok(new ResponseModel("Fetch Success",null,flocks,null));
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }
    //delete a flock by id
    public ResponseEntity<?> deleteByFlockId(int id){
        try {
            flock_repo.deleteById(id);
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

    //delete all flocks
    public ResponseEntity<?> deleteAllFlocks(){
        try {
            flock_repo.deleteAll();
            return ResponseEntity.ok(new ResponseModel("Delete All Success",null,null,null));
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
