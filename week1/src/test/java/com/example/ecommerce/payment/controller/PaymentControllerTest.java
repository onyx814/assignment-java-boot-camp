package com.example.ecommerce.payment.controller;

import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.payment.model.Payment;
import com.example.ecommerce.payment.service.PaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    PaymentService paymentService;

    @Test
    @DisplayName("find all payment success : data จะไม่เป็น null")
    void findAll_Success() {
        //arrange
        List<Payment> paymentList = new ArrayList<>() ;
        Payment payment = new  Payment("CTV","เคาน์เตอร์เซอร์วิส");
        paymentList.add(payment);
        Mockito.when(paymentService.findAll()).thenReturn(paymentList);

        //act
        ResponseList result = testRestTemplate.getForObject("/payments",ResponseList.class);

        //assert
        assertNotNull(result.getData());
    }
}