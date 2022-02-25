package com.example.ecommerce.basket.controller;

import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.basket.model.BasketItem;
import com.example.ecommerce.basket.model.RequestBasketCreate;
import com.example.ecommerce.basket.service.BasketService;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import com.example.ecommerce.product.service.ProductService;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    BasketService basketService;

    @MockBean
    ProductRepository productRepository;

    @Test
    @DisplayName("create basket success : message header = Success! ")
    void createBasket_Success() throws Exception {
        //arrange
        Product product = new Product(1,"กระปุกออมสินหมูชมพู","กระปุกออมสินหมูชมพู มีรู หยอดยังไงก็ไม่เต็ม",new BigDecimal(55),1);
        RequestBasketCreate req = new RequestBasketCreate(1,product);
        when(basketService.createBasket(req)).thenReturn(0);

        //act
        ResponseObject result = testRestTemplate.postForObject("/baskets",req ,ResponseObject.class);

        //assert
        assertEquals(result.getHeader().getMessage(),"Success!");
    }

    @Test
    @DisplayName("find by id = 1 , result data is not null ")
    void findById_Success() {
        //arrange
        Basket basket = new Basket(1,new BigDecimal(55),null);
        when(basketService.findById(1)).thenReturn(Optional.of(basket));

        //ac
        ResponseObject result = testRestTemplate.getForObject("/baskets/1",ResponseObject.class);

        //assert
        assertNotNull(result.getData());

    }

    @Test
    @DisplayName(" update id=1 and status = 'CO', response code = 200 ")
    void updateStatus_Success() throws Exception {
        //arrange
        when(basketService.updateStatus(1, "CO")).thenReturn(Boolean.TRUE);

        //act
        HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<ResponseObject> result = testRestTemplate.exchange("/baskets/1?status=CO",HttpMethod.PUT,HttpEntity.EMPTY,  ResponseObject.class);

        //assert
        assertTrue(result.getBody().getHeader().getCode().equals(HttpStatus.OK.value()));
    }

}