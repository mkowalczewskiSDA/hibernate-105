package com.sda.hibernate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    private Integer id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors;
}
