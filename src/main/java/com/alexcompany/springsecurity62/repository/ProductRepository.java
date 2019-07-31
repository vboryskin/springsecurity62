package com.alexcompany.springsecurity62.repository;

import com.alexcompany.springsecurity62.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
