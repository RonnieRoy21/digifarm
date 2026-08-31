package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Setter
@Getter

public class VaccinationSchedules {
    String vaccine_name,status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int completed_log_id;

    LocalDate scheduled_date;
    int flock_id;
}
