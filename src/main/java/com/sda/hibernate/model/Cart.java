package com.sda.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@IdClass(Cart.CartId.class)
public class Cart {

    @Id
    @ManyToOne
    @JoinColumn(name = "CRT_ORD_ID", referencedColumnName = "ORD_ID")
    Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "CRT_PRO_ID", referencedColumnName = "PRO_ID")
    Product product;
    @Column(name = "CRT_PRO_QUANTITY")
    int quantity;

    static class CartId implements Serializable {
        Integer order;
        Integer product;
    }
}
