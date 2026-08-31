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
public class EggsProductionLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    int flock_id,eggs_collected,eggs_broken;
    LocalDate log_date;
    String notes;
    UUID recorded_by;

}
