package com.medisoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "CITY")
    private String city;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "COUNTRY")
    private String country;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "COUNTY")
    private String county;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "LINE")
    private String line;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "POSTAL_CODE")
    private String postalCode;

}
