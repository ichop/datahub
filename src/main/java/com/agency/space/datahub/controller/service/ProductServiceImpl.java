package com.agency.space.datahub.controller.service;

import com.agency.space.datahub.controller.model.Coordinate;
import com.agency.space.datahub.controller.model.Product;
import com.agency.space.datahub.controller.repository.CoordinateRepository;
import com.agency.space.datahub.controller.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    CoordinateRepository coordinateRepository;

    public ProductServiceImpl(ProductRepository productRepository, CoordinateRepository coordinateRepository) {
        this.productRepository = productRepository;
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        ArrayList<Coordinate> coordinates = new ArrayList<>(product.getFootprint());
        for (Coordinate coordinate : coordinates){
            coordinateRepository.save(coordinate);
        }
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
