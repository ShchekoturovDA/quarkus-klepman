package com.shchek.pets.service;

import com.shchek.pets.model.Warehouse;
import com.shchek.pets.repository.WarehouseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;

@ApplicationScoped
public class WarehouseService {

    @Inject
    WarehouseRepository warehouseRepository;

    @Transactional
    public void addNew(String address) {
        if(warehouseRepository.findByAddress(address) != null) {
            throw new BadRequestException("По данному адресу зарегистрирован склад");
        }

        var warehouse = new Warehouse();
        warehouse.address = address;
        warehouse.products = new ArrayList<>();
        warehouseRepository.persistAndFlush(warehouse);
    }
}
