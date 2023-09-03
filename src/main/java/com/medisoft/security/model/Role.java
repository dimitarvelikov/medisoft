package com.medisoft.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

}
