package com.alexcompany.springsecurity62.serviceImplement;

import com.alexcompany.springsecurity62.dto.ProductDTO;
import com.alexcompany.springsecurity62.model.Product;
import com.alexcompany.springsecurity62.repository.ProductRepository;
import com.alexcompany.springsecurity62.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findOne(Long id) {
        return productRepository.findById(id);
    }
 //sout test
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public void saveNewProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setAmount(productDTO.getAmount());
        product.setManufacturer(productDTO.getManufacturer());
        product.setDescription("No description");
        product.setProductPicture("No picture");
        productRepository.save(product);
    }
}
