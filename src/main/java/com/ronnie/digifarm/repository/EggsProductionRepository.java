package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.EggsProductionLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggsProductionRepository extends JpaRepository<EggsProductionLogs,Integer> {
}
