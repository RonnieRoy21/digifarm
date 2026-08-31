package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Flocks {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id;
    UUID created_by;
    LocalDate start_date;
    int current_count,initial_count;
    String batch_code,breed,purpose,status;

LocalDateTime created_at;

}
