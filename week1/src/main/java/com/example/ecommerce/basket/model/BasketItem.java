package com.example.ecommerce.basket.model;

import com.example.ecommerce.product.model.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "basket_item")
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_amount")
    private  BigDecimal totalAmount;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id" ,nullable = false)
    private Basket basket;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", referencedColumnName = "id" ,nullable = false)
    private Product product;

    public BasketItem() {
    }

    public BasketItem(BigDecimal price, Integer quantity, BigDecimal totalAmount, Basket basket, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.basket = basket;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
