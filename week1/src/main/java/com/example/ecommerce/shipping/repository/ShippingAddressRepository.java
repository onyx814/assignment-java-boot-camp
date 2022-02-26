package com.example.ecommerce.shipping.repository;

import com.example.ecommerce.shipping.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {

}
