package com.example.ecommerce.member.repository;

import com.example.ecommerce.member.model.User;
import com.example.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findById(int id);


}
