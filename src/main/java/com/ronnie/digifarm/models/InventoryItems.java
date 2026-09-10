package com.ronnie.digifarm.models;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int quantity_on_hand, reorder_threshold;

    String item_name, unit;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    InventoryCategory category;

    String last_updated;
}
