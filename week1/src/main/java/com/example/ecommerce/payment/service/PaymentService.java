package com.example.ecommerce.payment.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.payment.model.Payment;
import com.example.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        List<Payment> result = paymentRepository.findAll();
        if(result.isEmpty()){
            throw new BaseNotFoundException(Payment.class.getSimpleName());
        }
        return  result;
    }
}
