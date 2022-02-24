package com.example.ecommerce.member.repository;

import com.example.ecommerce.member.model.Address;
import com.example.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {


     Optional<Address> findByDefaultShippingAndUserId(String flag, int userId);
     /* not use
     List<Address> findAll();
     */
}
