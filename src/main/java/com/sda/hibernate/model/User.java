package com.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Integer id;
    @Column(name = "USR_BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name = "USR_FIRST_NAME")
    private String firstName;
    @Column(name = "USR_LAST_NAME")
    private String lastName;
    @Column(name = "USR_EMAIL")
    private String email;
    @Column(name = "USR_PASSWORD")
    private String password;
    @OneToOne
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;


}
