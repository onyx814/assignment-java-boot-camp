package com.example.ecommerce.payment.repository;

import com.example.ecommerce.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    List<Payment> findAll();
}
