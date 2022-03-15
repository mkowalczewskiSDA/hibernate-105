package com.sda.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private Integer id;
    @Column(name = "ORD_DATE")
    private LocalDateTime orderDate;
    @Column(name = "ORD_PRICE")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
    private User user;


    @ManyToMany
    @JoinTable(name = "Cart",
            joinColumns = {@JoinColumn(name = "CRT_ORD_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CRT_PRO_ID")}
    )
    private Set<Product> products;

}
