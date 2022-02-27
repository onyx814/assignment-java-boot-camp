package com.example.ecommerce.order.model;

import com.example.ecommerce.basket.model.Basket;

public class OrderReq {

    private int paymentId;
    private Basket basket;

    public OrderReq() {
    }

    public OrderReq(int paymentId, Basket basket) {
        this.paymentId = paymentId;
        this.basket = basket;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
