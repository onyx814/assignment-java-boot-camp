package com.example.ecommerce.order.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.order.model.OrderReq;
import com.example.ecommerce.order.model.Orders;
import com.example.ecommerce.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrdersController extends BaseController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/confirm")
    public ResponseObject<Integer> confirmOrder(@RequestBody OrderReq req) throws  Exception{
        return createResponse(ordersService.confirmOrders(req));
    }

    @GetMapping("/{id}")
    public  ResponseObject<Orders> findById(@PathVariable int id){
        return  createResponse(ordersService.findById(id));
    }
}
