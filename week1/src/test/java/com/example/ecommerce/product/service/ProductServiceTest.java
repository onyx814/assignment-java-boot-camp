package com.example.ecommerce.product.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // จำลอง class ต่างๆ ที่เกี่ยวข้อง โดย mockito
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("search all success : list not empty ")
    void findAll_Success() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
        pList.add(product);
        when(productRepository.findAll()).thenReturn(pList);

        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.findAll();

        //assert
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("ถ้า ไม่มี product จะต้อง มี exception เกิดขึ้น  ")
    void findAll_NotFound() {
        //arrange
//        List<Product> pList = new ArrayList<Product>();
//        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
//        pList.add(product);
//        when(productRepository.findAll()).thenReturn(pList);

        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        BaseNotFoundException exception =  assertThrows(BaseNotFoundException.class, productService::findAll);

        //assert
        assertEquals(exception.getMessage(), Product.class.getSimpleName());

    }



    @Test
    @DisplayName("search by name success : list not empty ")
    void findByName_Success() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
        pList.add(product);
        when(productRepository.findByNameContaining("แจ")).thenReturn(pList);

        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.findByName("แจ");

        //assert
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("ค้นด้วยชื่อ = สาว ไม่เจอ จะต้องเกิด exception ที่ BaseNotFoundException ")
    void findByName_NotFound() {
        //arrange
        List<Product> pList = new ArrayList<>();
        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
        pList.add(product);
        when(productRepository.findByNameContaining("แจกัน")).thenReturn(pList);
        when(productRepository.findByNameContaining("สาว")).thenReturn(new ArrayList<>());

        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        BaseNotFoundException ex =  assertThrows(BaseNotFoundException.class, ()-> productService.findByName("สาว"));
        //assert
        assertNotNull(ex.getMessage());

    }

    @Test
    @DisplayName("search by id =1  result ไม่เป็น  null")
    void findById_Success() {
        //arrange
        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<Product> result = productService.findById(1);

        //assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("ค้นด้วย id = 2 ไม่เจอ จะต้องได้ exception message = Product id = 2 Not Found! ")
    void findById_NotFound() {
        //arrange

        Product product = new Product("แจกัน", "แจกันจากราชวงศ์หมิง เพราะเป็นแจกันคุณหมิง", new BigDecimal(9000));

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Throwable throwable = new BaseNotFoundException("Product id = 2 Not Found!");
        when(productRepository.findById(2)).thenThrow(throwable);


        //act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        BaseNotFoundException ex =  assertThrows(BaseNotFoundException.class, ()-> productService.findById(2));
        //assert
        assertTrue(ex.getMessage().contains("Product id = 2 Not Found!"));

    }
}