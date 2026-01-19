package org.launchcode.route_runner.controllers;

import org.apache.coyote.Response;
import org.launchcode.route_runner.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Value
    private String uploadDir;

@PostMapping("/listings")
    public ResponseEntity<?> createListing(@RequestBody Map<String, Double> productData){
        String name = String.valueOf(productData.get("name"));
        Double price = productData.get("price");
        String description = String.valueOf(productData.get("description"));
}


}
