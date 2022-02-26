package com.example.ecommerce.basket.model;

import com.example.ecommerce.member.model.User;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.shipping.model.ShippingAddress;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "status")
    private String status;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id" ,nullable = false)
    private User user;

    @OneToMany(mappedBy = "basket" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BasketItem> basketItemList;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private ShippingAddress shippingAddress;

    public Basket() {
    }

    public Basket(int id, BigDecimal totalAmount, String status) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Basket(BigDecimal totalAmount, String status, User user) {
        this.totalAmount = totalAmount;
        this.status = status;
        this.user = user;
    }

    public Basket(int id, BigDecimal totalAmount, String status, User user, List<BasketItem> basketItemList) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.user = user;
        this.basketItemList = basketItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public void setBasketItemList(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
