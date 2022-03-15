package com.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Author {

    @Id
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "AU_ID")},
            inverseJoinColumns = {@JoinColumn(name = "BO_ID")}
    )
    private Set<Book> books;


}
