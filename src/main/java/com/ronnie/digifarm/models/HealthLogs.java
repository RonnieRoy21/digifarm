package com.ronnie.digifarm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    HealthEventType event_type;

    String medication_name, dosage, notes;
    String event_date;
}
