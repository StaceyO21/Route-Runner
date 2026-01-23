package org.launchcode.route_runner.service;

import org.launchcode.route_runner.data.ProductsRepository;
import org.launchcode.route_runner.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public Products save(Products products){
        return productsRepository.save(products);
    }

    public Optional<Products> findProductsById(Long id){
        return productsRepository.findById(id);
    }

    public void updateProducts(Products products){
        productsRepository.save(products);
    }


}
