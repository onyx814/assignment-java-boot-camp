package com.example.ecommerce.product.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public  ResponseList findAll(){
        return  createResponse(productService.findAll());
    }

    @GetMapping("/catalog/{name}")
    public ResponseList findByName(@PathVariable String name){
        return  createResponse(productService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseObject findById(@PathVariable int id){
        return createResponse(productService.findById(id));

    }




}
