package com.example.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3.model.product;
import com.example.project3.repository.ProductRepository;

@Service
public class productService {

    @Autowired
    ProductRepository productRepository;

    // Get all products
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by id
    public product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Save product
    public product saveProduct(product product) {
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}