package com.example.ecommerce.core.exception;

import com.example.ecommerce.core.model.ResponseBase;
import com.example.ecommerce.core.model.ResponseHeader;
import com.example.ecommerce.core.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseControllerAdvice {

    private  ResponseHeader initHeaderFail(Integer code, String message){
        return new ResponseHeader(code,message);
    }

    @ExceptionHandler(BaseNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseObject notFoundException(BaseNotFoundException e){
        return  new ResponseObject(this.initHeaderFail(HttpStatus.NOT_FOUND.value(),e.getMessage()+" "+HttpStatus.NOT_FOUND.getReasonPhrase()+ "!"), null);
    }
}
