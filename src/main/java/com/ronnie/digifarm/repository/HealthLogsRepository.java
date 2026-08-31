package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.HealthLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthLogsRepository extends JpaRepository<HealthLogs,Integer> {
}
