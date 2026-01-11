package org.launchcode.route_runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired ProductRepository productRepository;
}
