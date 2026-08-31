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
@Setter
@Getter
public class WeightLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    int flock_id,sample_size,total_weight_kg ;
    float avg_weight_kg;
    LocalDate log_date; UUID recorded_by;
}
