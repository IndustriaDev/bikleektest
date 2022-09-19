package com.example.bikleektest.converters;

import com.example.bikleektest.domain.dtos.ProductDTO;
import com.example.bikleektest.domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductDtoConverter {

    private final ModelMapper modelMapper;

    public ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
