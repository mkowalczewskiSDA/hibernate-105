package com.sda.hibernate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NamedEntityGraphs(
        {
                @NamedEntityGraph(
                        name = "user-address",
                        attributeNodes = {
                                @NamedAttributeNode("address")
                        }
                ),
                @NamedEntityGraph(
                        name = "user-address-country",
                        attributeNodes = {
                                @NamedAttributeNode(value = "address", subgraph = "address-country")
                        },
                        subgraphs = {
                                @NamedSubgraph(
                                        name = "address-country",
                                        attributeNodes = {
                                                @NamedAttributeNode("country")
                                        }
                                )
                        }
                )
        }
)
@Entity
@Data
@ToString(exclude = {"address", "orders"})
@EqualsAndHashCode(exclude = {"address", "orders"})
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;


}
