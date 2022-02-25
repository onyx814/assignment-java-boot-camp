package com.example.ecommerce.product.controller;

import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository; //จำลอง Bean ไม่เอา DB จริง

    @Test
    @DisplayName("search all success : data จะต้องไม่เป็น null ")
    void findAll_Success() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000),10);
        pList.add(product);
        when(productRepository.findAll()).thenReturn(pList);

        //act
        ResponseList result = testRestTemplate.getForObject("/products", ResponseList.class);

        //assert
        assertNotNull(result.getData());
    }
    @Test
    @DisplayName("search all  : ถ้าไม่พบ จะแสดงข้อความ Product Not Found! ")
    void findAll_NotFound() {
        //arrange
//        List<Product> pList = new ArrayList<Product>();
//        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
//        pList.add(product);
//        when(productRepository.findAll()).thenReturn(pList);

        //act
        ResponseList result = testRestTemplate.getForObject("/products", ResponseList.class);

        //assert
        assertEquals("Product Not Found!",result.getHeader().getMessage());
    }

    @Test
    @DisplayName("search product ด้วยชื่อ = หมิง  คาดหวังว่า data ที่ได้ ต้องไม่เป็น null")
    void findByName_Success() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกันจากราชวงศ์หมิง", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000),15);
        pList.add(product);
        product = new Product("แจกันจากราชวงฮั่นแน่", "แจกันจากราชวงฮั่นแน่ ถ้าฮั่นไม่แน่ ฮั้นจะไม่มา", new BigDecimal(9900),23);
        pList.add(product);
        when(productRepository.findByNameContaining("หมิง")).thenReturn(pList);

        //act
        ResponseList result = testRestTemplate.getForObject("/products/catalog/หมิง", ResponseList.class);

        //assert
        assertNotNull(result.getData());
    }

    @Test
    @DisplayName("search product ด้วยชื่อ = หมิง  ถ้าไม่พบ จะแสดงข้อความ Product name = หมิง Not Found!")
    void findByName_NotFound() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกันจากราชวงฮั่นแน่", "แจกันจากราชวงฮั่นแน่ ถ้าฮั่นไม่แน่ ฮั้นจะไม่มา", new BigDecimal(9900),2);
        pList.add(product);
        when(productRepository.findByNameContaining("ฮั่น")).thenReturn(pList);

        //act
        ResponseList result = testRestTemplate.getForObject("/products/catalog/หมิง", ResponseList.class);

        //assert
        assertEquals("Product name = หมิง Not Found!",result.getHeader().getMessage());
    }

    @Test
    @DisplayName("ค้นหา product ด้วย id = 1 ผลลัพธ์จะต้องไม่เป็น null ")
    void findById_Success() {
        //arrange

        Product product = new Product("แจกันจากราชวงศ์หมิง", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000),3);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        //act
        ResponseObject result = testRestTemplate.getForObject("/products/1", ResponseObject.class);

        //assert
        assertNotNull(result.getData());
    }

    @Test
    @DisplayName("search by id = 5 : ถ้า ไม่พบ จะแสดงข้อความ Product id = 5 Not Found!")
    void findById_NotFound() {
        //arrange
        Product product = new Product("แจกันจากราชวงฮั่นแน่", "แจกันจากราชวงฮั่นแน่ ถ้าฮั่นไม่แน่ ฮั้นจะไม่มา", new BigDecimal(9900),3);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        //act
        ResponseObject result = testRestTemplate.getForObject("/products/5", ResponseObject.class);

        //assert
        assertEquals("Product id = 5 Not Found!",result.getHeader().getMessage());

    }
}