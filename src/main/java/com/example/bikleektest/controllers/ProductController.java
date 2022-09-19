package com.example.bikleektest.controllers;

import com.example.bikleektest.domain.dtos.ProductDTO;
import com.example.bikleektest.domain.models.Product;
import com.example.bikleektest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> productAll() {
        return productService.findAll();
    }

    @PostMapping(value="/products")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
        ProductDTO productSaved = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }
}
