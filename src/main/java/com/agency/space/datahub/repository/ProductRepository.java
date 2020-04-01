package com.agency.space.datahub.repository;

import com.agency.space.datahub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
