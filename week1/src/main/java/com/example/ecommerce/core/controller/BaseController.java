package com.example.ecommerce.core.controller;

import com.example.ecommerce.core.model.ResponseBase;
import com.example.ecommerce.core.model.ResponseHeader;
import com.example.ecommerce.core.model.ResponseList;
import com.example.ecommerce.core.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController<T> {

    private  ResponseHeader initHeaderSuccess(){
        return new ResponseHeader(HttpStatus.OK.value(),"Success!");
    }

    public ResponseObject  createResponse( T response){
        return  new ResponseObject(this.initHeaderSuccess(), response);
    }


    public ResponseList createResponse(List<T> response){
       return new ResponseList( this.initHeaderSuccess(),response);
    }
}
