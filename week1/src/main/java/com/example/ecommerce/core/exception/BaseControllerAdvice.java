package com.example.ecommerce.core.exception;

import com.example.ecommerce.core.model.ResponseBase;
import com.example.ecommerce.core.model.ResponseHeader;
import com.example.ecommerce.core.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseObject handleException(Exception e){
        Object ex = e;
        return  new ResponseObject(this.initHeaderFail(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() ),null);
    }


}
