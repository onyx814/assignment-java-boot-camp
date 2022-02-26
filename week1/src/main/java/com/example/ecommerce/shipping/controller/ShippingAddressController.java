package com.example.ecommerce.shipping.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.shipping.model.ShippingAddressBasketReq;
import com.example.ecommerce.shipping.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shipping-address")
public class ShippingAddressController extends BaseController {

    @Autowired
    ShippingAddressService shippingAddressService;

    @PostMapping()
    public ResponseObject<Boolean> createShippingAddress(@RequestBody ShippingAddressBasketReq req) throws Exception {

       return createResponse(shippingAddressService.createShippingAddress(req)) ;
    }
}
