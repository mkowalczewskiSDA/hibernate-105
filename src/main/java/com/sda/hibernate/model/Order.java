package com.sda.hibernate.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "`Order`")
public class Order extends EntityInfo {

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
    @OneToMany(mappedBy = "order")
    private Set<Cart> cartValues;



}
