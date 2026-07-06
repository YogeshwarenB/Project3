package com.example.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project3.model.product ;

public interface ProductRepository extends JpaRepository<product, Long> {

}