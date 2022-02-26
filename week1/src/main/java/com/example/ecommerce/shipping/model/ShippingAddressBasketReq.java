package com.example.ecommerce.shipping.model;

public class ShippingAddressBasketReq {

    private  int basketId;
    private  ShippingAddress shippingAddress;

    public ShippingAddressBasketReq() {
    }

    public ShippingAddressBasketReq(int basketId, ShippingAddress shippingAddress) {
        this.basketId = basketId;
        this.shippingAddress = shippingAddress;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
