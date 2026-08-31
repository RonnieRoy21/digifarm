package com.ronnie.digifarm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Expenses {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    UUID recorded_by;
    int flock_id,amount;
    String category,expense_date,description;
}
