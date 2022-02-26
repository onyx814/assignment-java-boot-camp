package com.example.ecommerce.shipping.controller;

import com.example.ecommerce.basket.model.RequestBasketCreate;
import com.example.ecommerce.basket.service.BasketService;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.shipping.model.ShippingAddress;
import com.example.ecommerce.shipping.model.ShippingAddressBasketReq;
import com.example.ecommerce.shipping.service.ShippingAddressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShippingAddressControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ShippingAddressService shippingAddressService;

    @MockBean
    BasketService basketService;

    @Test
    @DisplayName("create shipping address success  return code = 200")
    void createShippingAddress_Success() throws Exception {
        //arrange
        ShippingAddress shippingAddress = new ShippingAddress("เลขที่ 25 ABCDEFU Condo ถนนอ่อนนุช พระโขนงเหนือ","10260","วัฒนา","กรุงเทพมหานคร","0891234567");
        ShippingAddressBasketReq req = new ShippingAddressBasketReq(1,shippingAddress);
        when(shippingAddressService.createShippingAddress(req)).thenReturn(Boolean.TRUE.booleanValue());

        //action
        ResponseObject result =testRestTemplate.postForObject("/shipping-address",req,ResponseObject.class);

        //assert
        assertEquals(result.getHeader().getCode(), HttpStatus.OK.value());
    }
}