package com.ronnie.digifarm.repository;

import com.ronnie.digifarm.models.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemsRepository extends JpaRepository<InventoryItems,Integer> {
}
