package com.example.ecommerce.order.controller;

import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.order.model.OrderReq;
import com.example.ecommerce.order.model.Orders;
import com.example.ecommerce.order.service.OrdersService;
import com.example.ecommerce.payment.model.Payment;
import com.example.ecommerce.payment.model.PaymentTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrdersControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private OrdersService ordersService;


    @Test
    @DisplayName(" confirm order success จะต้อง มี code http status = 200 ")
    void confirmOrder_Success() throws Exception {
        //arrange
        OrderReq req = new OrderReq(1,new Basket());
        Mockito.when(ordersService.confirmOrders(req)).thenReturn(1);

        //act
        ResponseObject<Integer> result = testRestTemplate.postForObject("/orders/confirm", req, ResponseObject.class);

        //assert
        assertEquals(result.getHeader().getCode(),HttpStatus.OK.value());
    }

    @Test
    @DisplayName("ค้นหา oders ด้วย id = 1 , data จะต้องไม่เป็น null และ code http status = 200")
    void findById_Success() {
        //arrange
        PaymentTransaction paymentTransaction = new PaymentTransaction(new BigDecimal(70),"N",null,new Basket(),new Payment());
        Orders orders = new Orders("INV20220226",new Date(),new Date(),null,paymentTransaction);
        Mockito.when(ordersService.findById(1)).thenReturn(Optional.of(orders));

        //act
        ResponseObject result = testRestTemplate.getForObject("/addresses/default/user/1", ResponseObject.class);

        //assert
        assertNotNull(result.getData());
        assertEquals(result.getHeader().getCode(), HttpStatus.OK.value());
    }
}