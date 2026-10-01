package com.shchek.pets.repository;

import com.shchek.pets.model.Warehouse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WarehouseRepository implements PanacheRepository<Warehouse> {

    public Warehouse findByAddress(String address) {
        return find("address", address).firstResult();
    }
}
