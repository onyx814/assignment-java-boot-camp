package com.example.ecommerce.core.model;

import java.util.List;

public class ResponseObject<T> extends ResponseBase {

    private T data;

    public ResponseObject() {
    }

    public ResponseObject(ResponseHeader header, T data) {
        this.setHeader(header);
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
