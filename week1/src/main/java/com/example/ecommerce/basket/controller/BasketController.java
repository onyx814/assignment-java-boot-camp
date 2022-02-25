package com.example.ecommerce.basket.controller;

import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.basket.model.RequestBasketCreate;
import com.example.ecommerce.basket.service.BasketService;
import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseObject;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("baskets")
public class BasketController extends BaseController {
    @Autowired
    BasketService basketService;


    @PostMapping()
    public ResponseObject<Integer> createBasket(@RequestBody RequestBasketCreate item) throws Exception  {
            Integer result = basketService.createBasket(item);
            return createResponse(result);
    }

    @GetMapping("/{id}")
    public  ResponseObject<Basket> findById(@PathVariable int id){
        return  createResponse(basketService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public  ResponseObject<Boolean> updateStatus(@PathVariable int id, @RequestParam(value = "status", required = true) String status)throws  Exception{
        return  createResponse(basketService.updateStatus(id,status));
    }


}
