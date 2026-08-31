package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
}
