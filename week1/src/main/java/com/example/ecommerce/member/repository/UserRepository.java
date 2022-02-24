package com.example.ecommerce.member.repository;

import com.example.ecommerce.member.model.User;
import com.example.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
