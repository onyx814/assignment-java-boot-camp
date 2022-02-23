package com.example.ecommerce.product.repository;

import com.example.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAll();

    List<Product> findByNameContaining(String name);

    Optional<Product> findById(int id);


}
