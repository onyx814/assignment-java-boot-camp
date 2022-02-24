package com.example.ecommerce.member.controller;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.member.model.Address;
import com.example.ecommerce.member.model.User;
import com.example.ecommerce.member.repository.AddressRepository;
import com.example.ecommerce.member.repository.UserRepository;
import com.example.ecommerce.product.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    AddressRepository addressRepository;


    @Test
    @DisplayName("ค้นหาที่อยู่หลักของ user id =1 data จะต้องไม่เท่ากับ null")
    void findDefaultAddressByUserId_Success() {
        //arrange
        User user = new User(1,"กระต่าย หมายจันทร์","rabbit@gmail.com","076543210");
        Address address = new Address(1,"เลขที่1 ถนนบางนา-ตราด","10270","บางนา","กรุงเทพมหานคร","028918920","Y",user);
        when(addressRepository.findByDefaultShippingAndUserId("Y",1)).thenReturn(Optional.of(address));

        //act
        ResponseObject result = testRestTemplate.getForObject("/addresses/default/user/1", ResponseObject.class);

        //assert
        assertNotNull(result.getData());
    }

    @Test
    @DisplayName("ค้นหาที่อยู่หลักของ user id =2 data ถ้าไม่เจอ http status = 404")
    void findDefaultAddressByUserId_NotFound() {
//        //arrange
        User user = new User(1,"กระต่าย หมายจันทร์","rabbit@gmail.com","076543210");
        Address address = new Address(1,"เลขที่1 ถนนบางนา-ตราด","10270","บางนา","กรุงเทพมหานคร","028918920","Y",user);
        when(addressRepository.findByDefaultShippingAndUserId("Y",1)).thenReturn(Optional.of(address));
        when(addressRepository.findByDefaultShippingAndUserId("Y",2)).thenThrow( new BaseNotFoundException(Address.class.getSimpleName()+" Default Of User Id = 2"));

        //act
        ResponseEntity<ResponseObject> result = testRestTemplate.getForEntity("/addresses/default/user/2",ResponseObject.class);

        //assert
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }
}