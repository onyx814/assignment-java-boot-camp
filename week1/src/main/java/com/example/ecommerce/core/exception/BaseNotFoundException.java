package com.example.ecommerce.core.exception;

public class BaseNotFoundException extends  RuntimeException{
    public BaseNotFoundException (String name){
        super(name);
    }
}
