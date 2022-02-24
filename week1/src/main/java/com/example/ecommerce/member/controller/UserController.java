package com.example.ecommerce.member.controller;

import com.example.ecommerce.core.controller.BaseController;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import com.example.ecommerce.member.service.AddressService;
import com.example.ecommerce.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseObject findById(@PathVariable int id){
        return  createResponse(userService.findById(id));
    }

    /* not use
    @GetMapping()
    public ResponseList findAll(){
        return  createResponse(userService.findAll());
    }
    */


}
