package com.example.ecommerce.payment.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentController extends BaseController {

    @Autowired
    PaymentService paymentService;

    @GetMapping()
    public ResponseList findAll(){
        return createResponse(paymentService.findAll());
    }
}
