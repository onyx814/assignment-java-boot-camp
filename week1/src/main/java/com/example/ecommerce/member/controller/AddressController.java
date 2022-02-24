package com.example.ecommerce.member.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.member.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {

    @Autowired
    AddressService addressService;

    @GetMapping("/default/user/{id}")
    public ResponseObject findDefaultAddressByUserId(@PathVariable int id){
        return  createResponse(addressService.findDefaultAddressByUserId(id));
    }



    /* not use
    @GetMapping()
    public ResponseList findAll(){
        return  createResponse(addressService.findAll());
    }
     */





}
