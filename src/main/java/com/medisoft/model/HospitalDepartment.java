package com.medisoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "HOSPITAL_DEPARTMENT")
@Entity
public class HospitalDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private int capacity;

    //private List<User> users;
}
