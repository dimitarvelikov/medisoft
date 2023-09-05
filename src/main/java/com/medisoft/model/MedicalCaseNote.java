package com.medisoft.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "MEDICAL_CASE_NOTE")
public class MedicalCaseNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "MEDICAL_CASE_ID")
    private int medicalCaseId;

    @Column(name = "NOTE")
    private String note;
}
