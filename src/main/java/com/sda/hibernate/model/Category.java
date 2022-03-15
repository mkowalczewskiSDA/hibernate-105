package com.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAT_ID")
    private Integer id;
    @Column(name = "CAT_NAME")
    private String name;
}
