package com.example.ecommerce.basket.model;

import com.example.ecommerce.product.model.Product;

public class RequestBasketCreate {

    private  int userId;
    private Product product;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
