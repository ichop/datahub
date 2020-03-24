package com.agency.space.datahub.controller.repository;

import com.agency.space.datahub.controller.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
