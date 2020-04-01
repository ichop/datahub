package com.agency.space.datahub.service;

import com.agency.space.datahub.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    Product getById(Long id);

    void save(Product product);

    void delete(Long id);

    List<Product> getAll();

    List<Product> getByMissionName(String name);

    List<Product> getByDateBefore(LocalDateTime date);

    List<Product> getByDateAfter(LocalDateTime date);

    List<Product> getByDateBetween(LocalDateTime fromDate, LocalDateTime toDate);

    List<Product> orderProducts(List<Long> ids);
}
