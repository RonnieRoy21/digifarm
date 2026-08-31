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
public class FeedLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int flock_id,feed_item_id,quantity_kg,cost;
    UUID recorded_by;
    LocalDate log_date;



}
