package org.launchcode.route_runner.controllers;

import org.apache.coyote.Response;
import org.launchcode.route_runner.models.Products;
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

@PostMapping("/add-listing")
    public ResponseEntity<?> createListing(@RequestBody Map<String, Double> productsDTO){
        String name = String.valueOf(productsDTO.get("name"));
        Double price = productsDTO.get("price");
        String description = String.valueOf(productsDTO.get("description"));

        Products newProducts = new Products();
        newProducts.setName(name);
        newProducts.setPrice(price);
        newProducts.setDescription(description);

        productsService.save(newProducts);

        return ResponseEntity.ok(newProducts);
}



}
