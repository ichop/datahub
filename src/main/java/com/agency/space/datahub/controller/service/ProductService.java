package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long id);
    void save(Product product);
    void delete(Long id);
    List<Product> getAll();
}
