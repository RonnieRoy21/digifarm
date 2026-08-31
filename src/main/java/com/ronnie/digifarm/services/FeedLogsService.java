package com.ronnie.digifarm.services;


import com.ronnie.digifarm.models.FeedLogs;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.FeedLogsRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class FeedLogsService {
    FeedLogsRepository feed_repo;
    public FeedLogsService(FeedLogsRepository feedLogsRepository){
        this.feed_repo=feedLogsRepository;
    }


    //add feed log
    public ResponseEntity<?> addFeedLog(FeedLogs log){
        try{
            feed_repo.save(log);
            return ResponseEntity.ok(new ResponseModel("Feed Log Added",null,null,null));
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }


    //add a bunch of logs
    public ResponseEntity<?> addFeedLogs(List<FeedLogs> logs){
        try{
            feed_repo.saveAll(logs);
            return ResponseEntity.ok(new ResponseModel("Feed Logs Added",null,null,null));
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }


    //edit a log field by id
    public ResponseEntity<?> editFeedLog(FeedLogs log){
        try{
            feed_repo.save(log);
            return ResponseEntity.ok(new ResponseModel("Feed Log Added",null,null,null));
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }


    //delete a log
    public ResponseEntity<?> deleteFeedLog(FeedLogs log){
        try{
            feed_repo.delete(log);
            return ResponseEntity.ok(new ResponseModel("Feed Log Added",null,null,null));
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Constraint Error ",null,null,e.getMessage()));

        }catch(DataAccessException e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Storage Error ",null,null,e.getMessage()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseModel("Other Error ",null,null,e.getMessage()));
        }

    }


    //retrieve logs
    public ResponseEntity<?> getFeedLogs(){
        try{
            List<FeedLogs> logs=feed_repo.findAll();
            return ResponseEntity.ok(new ResponseModel("Feed Log Added",null,logs,null));
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
