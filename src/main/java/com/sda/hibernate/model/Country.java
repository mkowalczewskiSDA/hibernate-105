package com.sda.hibernate.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID")
    private Integer id;
    @Column(name = "CO_NAME")
    private String name;
    @Column(name = "CO_ALIAS")
    private String alias;



}
