package com.alexcompany.springsecurity62.service;

import com.alexcompany.springsecurity62.dto.ProductDTO;
import com.alexcompany.springsecurity62.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findOne(Long id);
    List<Product> findAll();
    List<Product> findAll(Pageable pageable);
    void saveNewProduct(ProductDTO productDTO);
    void delete(Long id);
}
