package com.example.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project3.model.product;
import com.example.project3.service.productService;

@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    productService productService;

    // GET all products
    @GetMapping
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET product by id
    @GetMapping("/{id}")
    public product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST create product
    @PostMapping
    public product createProduct(@RequestBody product product) {
        return productService.saveProduct(product);
    }

    // UPDATE product
    @PutMapping("/{id}")
    public product updateProduct(@PathVariable Long id,
                                 @RequestBody product updatedProduct) {

        product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());

            return productService.saveProduct(existingProduct);
        }

        return null;
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }
}