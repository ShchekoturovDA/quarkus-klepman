package com.shchek.pets.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "deal")
public class Deal extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "sysName")
    public String fio;

    @ManyToOne
    @JoinColumn(name = "customer")
    public Customer customer;
}