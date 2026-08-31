package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.InventoryTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionsRepository extends JpaRepository<InventoryTransactions,Integer> {
}
