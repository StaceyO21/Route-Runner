package org.launchcode.route_runner.service;

import org.launchcode.route_runner.data.ProductsRepository;
import org.launchcode.route_runner.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public Products save(Products products){
        return productsRepository.save(products);
    }
}
