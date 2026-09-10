package com.ronnie.digifarm.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Users {
    @Id
    UUID id;

    String name;


    String email;

    String role;
    String created_at;
}
