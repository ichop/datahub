package com.agency.space.datahub.service;


import com.agency.space.datahub.model.Product;

import com.agency.space.datahub.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByMissionName(String name) {
        List<Product> products =  productRepository.findAll();

        return products.stream()
                .filter(product -> product.getMission().getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByDateBefore(LocalDateTime date) {
        List<Product> products =  productRepository.findAll();

        return products.stream()
                .filter(product -> product.getAcquisitionDate().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByDateAfter(LocalDateTime date) {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .filter(product -> product.getAcquisitionDate().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByDateBetween(LocalDateTime fromDate, LocalDateTime toDate) {
        List<Product> products =  productRepository.findAll();

        return products.stream()
                .filter(product -> (product.getAcquisitionDate().isAfter(fromDate) && product.getAcquisitionDate().isBefore(toDate)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> orderProducts(List<Long> ids) {
        List<Product> products =  productRepository.findAll();

       return products.stream()
                    .filter(product -> ids.contains(product.getId()))
                    .collect(Collectors.toList());
    }
}
