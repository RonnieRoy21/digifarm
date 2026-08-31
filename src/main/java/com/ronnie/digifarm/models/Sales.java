package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int flock_id,quantity,unit_price,total_amount,amount_paid;
    String product_type,buyer_name,buyer_contact,payment_status;
    UUID recorded_by;
    LocalDate sale_date;

}
