package com.ronnie.digifarm.controllers;

import com.ronnie.digifarm.models.FeedLogs;
import com.ronnie.digifarm.services.FeedLogsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedLogsController {

    FeedLogsService feed_service;

    public FeedLogsController(FeedLogsService feedLogsService){
        this.feed_service=feedLogsService;
    }

    @GetMapping("/getLogs")
    public ResponseEntity<?> getAllFeedLogs(){
        return feed_service.getFeedLogs();
    }

    @PostMapping("/addLog")
    public ResponseEntity<?> insertFeedLog(@Validated @RequestBody FeedLogs log){
        return feed_service.addFeedLog(log);
    }

    @PostMapping("/addLogs")
    public ResponseEntity<?> insertManyFeedLogs(@Validated @RequestBody List<FeedLogs> logs) {
        return feed_service.addFeedLogs(logs);

    }

    @PutMapping("/editLog")
    public ResponseEntity<?> editSingleLog(@Validated @RequestBody FeedLogs log){
        return feed_service.editFeedLog(log);
    }

    @DeleteMapping("/deleteLog")
    public ResponseEntity<?> deleteLog(@Validated @RequestBody FeedLogs log){
        return feed_service.deleteFeedLog(log);
    }

}
