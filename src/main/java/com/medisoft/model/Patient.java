package com.medisoft.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "F_NAME")
    private String firstName;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "M_NAME")
    private String middleName;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "L_NAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date dateOfBirth;

    @NotEmpty
    @Size(min = 3,max = 40)
    @Column(name = "EMAIL")
    @Email(regexp = ".+[@].+[\\.].+")
    private String email;

    @NotEmpty
    @Column(name = "GENDER")
    private Character gender;

    @NotEmpty
    @Size(min = 3,max = 40)
    @Column(name = "NATIONALITY")
    private String nationality;

    //https://www.baeldung.com/java-libphonenumber
    //https://github.com/google/libphonenumber
    //todo check the library for important phone validations and to discuss with Velikov abouth the telephone

    @NotEmpty
    @Size(min = 3,max = 40)
    @Column(name = "TELEPHONE")
    private String telephone;

    @NotEmpty
    @Column(name = "ACTIVE")
    private Boolean active;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "SOCIAL_GROUP")
    private String socialGroup;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @NotEmpty
    @Size(min = 3,max = 30)
    @Column(name = "GENERAL_PRACTITIONER")
    private String generalPractitioner;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", nullable = false)
    public Set<Address> addresses;

    //todo
//    ADDRESS_ID NUMBER,
//    CONTACT_PERSON_ID NUMBER

}
