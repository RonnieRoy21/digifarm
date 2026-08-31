package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.FeedLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedLogsRepository extends JpaRepository<FeedLogs,Integer> {
}
