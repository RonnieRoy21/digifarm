package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter

public class VaccinationSchedules {
    String vaccine_name, status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int completed_log_id;

    String scheduled_date;
    int flock_id;
}
