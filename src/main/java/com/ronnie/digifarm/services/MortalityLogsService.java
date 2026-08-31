package com.ronnie.digifarm.services;
import com.ronnie.digifarm.models.MortalityLogs;
import com.ronnie.digifarm.models.ResponseModel;
import com.ronnie.digifarm.repository.MortalityLogsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class MortalityLogsService {

        private final MortalityLogsRepository mortality_repo;

        public MortalityLogsService(MortalityLogsRepository mortalityLogsRepository){
            this.mortality_repo=mortalityLogsRepository;
        }

        public ResponseEntity<?> processRequest(String action , MortalityLogs single, List<MortalityLogs> body){
            try{
                if (action.trim().isEmpty()){
                    return ResponseEntity.badRequest().body(new ResponseModel("Invalid Action",null,null,null));
                }
                return switch ( action.toLowerCase()) {
                    case "insert single" -> {
                        if(single == null){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        mortality_repo.save(single);
                        yield ResponseEntity.ok(new ResponseModel("Added Item ", null, null, null));
                    }
                    case "insert many" -> {
                        if(body.isEmpty()){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        mortality_repo.saveAll(body);
                        yield ResponseEntity.ok(new ResponseModel("Added Items ", null, null, null));
                    }
                    case "edit" -> {
                        if(single == null){
                            yield  ResponseEntity.badRequest().body(new ResponseModel("Can't insert null values",null,null,null));
                        }
                        mortality_repo.save(single);
                        yield ResponseEntity.ok(new ResponseModel("Updated Item ", null, null, null));
                    }
                    case "delete" -> {
                        mortality_repo.delete(single);
                        yield ResponseEntity.ok(new ResponseModel("Deleted Item ", null, null, null));
                    }
                    case "get" -> {
                        List<MortalityLogs> logs =    mortality_repo.findAll();
                        yield ResponseEntity.ok(new ResponseModel("Fetched Items ", null, logs, null));
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


