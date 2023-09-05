package com.medisoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Table(name = "ALERT")
@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SEVERITY")
    private String severity;
    @Column(name = "ACTIVE")
    private boolean active;
    @Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;
}
