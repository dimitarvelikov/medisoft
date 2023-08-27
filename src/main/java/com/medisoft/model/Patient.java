package com.medisoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EGN")
    @NotNull
    private String egn;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "F_NAME")
    private String firstName;

    //   @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "M_NAME")
    private String middleName;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "L_NAME")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "BIRTHDATE")
    private LocalDate dateOfBirth;

    //@NotEmpty
    //@Size(min = 3, max = 40)
    @Column(name = "EMAIL")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    //@NotEmpty
    //@Size(min = 1, max = 1)
    @Column(name = "GENDER")
    private String gender;

    //@NotEmpty
    //@Size(min = 3, max = 40)
    @Column(name = "NATIONALITY")
    private String nationality;

    //@NotEmpty
    //@Size(min = 3, max = 40)
    @Column(name = "PHONE")
    private String phoneNumber;

    //@NotNull
    @Column(name = "ACTIVE")
    private boolean active;

    //@NotEmpty
    //@Size(min = 3, max = 30)
    @Column(name = "SOCIAL_GROUP")
    private String socialGroup;

    //   @NotEmpty
    //   @Size(min = 3, max = 30)
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    //  @NotEmpty
    //  @Size(min = 3, max = 30)
    @Column(name = "GENERAL_PRACTITIONER")
    private String generalPractitioner;


    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinColumn(name = "ID", nullable = false)
    // public List<Address> addresses;

}
