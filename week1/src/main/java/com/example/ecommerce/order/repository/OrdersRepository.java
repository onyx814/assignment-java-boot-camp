package com.example.ecommerce.order.repository;

import com.example.ecommerce.order.model.Orders;
import com.example.ecommerce.payment.repository.PaymentTransactionRepository;
import com.example.ecommerce.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    @Modifying
    @Query(value = "insert into orders ( expire_date,invoice_no,status,transaction_date,payment_transaction_id ) " +
            "values(DATEADD('DAY',2,CURRENT_TIMESTAMP),'INV'||(TO_CHAR(CURRENT_TIMESTAMP,'YYYYMMDDHH24MIss')),null,CURRENT_TIMESTAMP,:payment_transaction_id)", nativeQuery = true)
    public int confirmOrder(@Param(value = "payment_transaction_id") int paymentTransactionId);

    Optional<Orders> findById(int id);
}
