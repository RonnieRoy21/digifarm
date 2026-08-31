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
public class HealthLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int flock_id;
    UUID recorded_by;
    String event_type,medication_name,dosage,notes;
    LocalDate event_date;
}
