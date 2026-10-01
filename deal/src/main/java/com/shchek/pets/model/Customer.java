package com.shchek.pets.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "fio")
    public String fio;

    @OneToMany(mappedBy = "customer")
    @Column(name = "deals")
    public List<Deal> deals;

}
