package com.example.bikleektest.service;

import com.example.bikleektest.domain.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    public ResponseEntity<?> findAll();

    public Page<ProductDTO> findAll(Pageable pageable);

    public ProductDTO findById(Long id);

    public ProductDTO save(ProductDTO product);
}
