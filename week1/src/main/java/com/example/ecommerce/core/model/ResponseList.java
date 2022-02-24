package com.example.ecommerce.core.model;

import java.util.List;

public class ResponseList<T> extends ResponseBase {

    private List<T> data;

    public ResponseList() {
    }

    public ResponseList(ResponseHeader header, List<T> data) {
        this.setHeader(header);
        this.setData(data);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
