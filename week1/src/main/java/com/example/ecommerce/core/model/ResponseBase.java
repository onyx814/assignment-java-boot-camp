package com.example.ecommerce.core.model;

public class ResponseBase<T>   {

    private ResponseHeader header;


    public ResponseBase() {
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }
}
