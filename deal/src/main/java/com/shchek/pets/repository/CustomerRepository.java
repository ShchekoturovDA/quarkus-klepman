package com.shchek.pets.repository;

import com.shchek.pets.model.Customer;
import com.shchek.pets.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class CustomerRepository implements PanacheRepository<Customer> {
}
