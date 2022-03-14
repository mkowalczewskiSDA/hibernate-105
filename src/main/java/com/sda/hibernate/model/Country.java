package com.sda.hibernate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NamedQueries({@NamedQuery(name = "country.select.all", query = "from Country")})
@ToString(exclude = "addresses")
@EqualsAndHashCode(exclude = "addresses")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID")
    private Integer id;
    @Column(name = "CO_NAME")
    private String name;
    @Column(name = "CO_ALIAS")
    private String alias;
    @OneToMany(mappedBy = "country")
    private Set<Address> addresses;



}
