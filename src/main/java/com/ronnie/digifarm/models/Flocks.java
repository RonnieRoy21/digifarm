package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Column;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Flocks {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id;
    UUID created_by;
    String start_date;
    int current_count,initial_count;
    String batch_code,breed,purpose,status;

String created_at;

}
