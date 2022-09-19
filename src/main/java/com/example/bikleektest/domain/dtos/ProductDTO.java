package com.example.bikleektest.domain.dtos;

import com.example.bikleektest.domain.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Float price;
    private Category category;
    private LocalDateTime createdTime;
}
