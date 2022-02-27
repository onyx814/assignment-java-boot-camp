package com.example.ecommerce.payment.model;


import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.order.model.Orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="payment_transaction")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "net_amount")
    private BigDecimal netAmount;

    @Column(name = "pay_status")
    private String payStatus;

    @Column(name = "pay_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private Basket basket ;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment ;


    @OneToOne(mappedBy = "paymentTransaction")
    private Orders orders;

    public PaymentTransaction() {
    }

    public PaymentTransaction(BigDecimal netAmount, String payStatus, Date payDate, Basket basket, Payment payment) {
        this.netAmount = netAmount;
        this.payStatus = payStatus;
        this.payDate = payDate;
        this.basket = basket;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
