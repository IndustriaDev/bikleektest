package com.example.bikleektest.service.impl;

import com.example.bikleektest.converters.ProductDtoConverter;
import com.example.bikleektest.domain.dtos.ProductDTO;
import com.example.bikleektest.domain.models.Product;
import com.example.bikleektest.domain.repositories.ProductRepository;
import com.example.bikleektest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoConverter productDtoConverter;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll() {
        List<Product> products = (List<Product>) productRepository.findAll();

        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            //return ResponseEntity.ok(products);
            List<ProductDTO> result = products.stream().map(productDtoConverter::convertToDto).collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductDTO findById(Long id) {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product productEntity = productDtoConverter.convertToEntity(product);
        Product productResult = productRepository.save(productEntity);
        product.setId(productResult.getId());
        return product;
    }
}
