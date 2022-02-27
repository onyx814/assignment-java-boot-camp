package com.example.ecommerce.order.service;

import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.basket.repository.BasketRepository;
import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.order.model.OrderReq;
import com.example.ecommerce.order.model.Orders;
import com.example.ecommerce.order.repository.OrdersRepository;
import com.example.ecommerce.payment.model.Payment;
import com.example.ecommerce.payment.model.PaymentTransaction;
import com.example.ecommerce.payment.repository.PaymentTransactionRepository;
import com.example.ecommerce.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public Integer confirmOrders(OrderReq formSave) throws Exception
    {
        Orders orders = new Orders();
        try {
            if(formSave == null)
                throw  new Exception("Data invalid");
            if(formSave.getBasket()==null)
                throw  new Exception("Data invalid");

            // update Basket status = 'CF'
            Basket basket = formSave.getBasket();
            if(!formSave.getBasket().getStatus().equals("CO")){
                throw  new Exception("Basket status invalid");
            }
            basketRepository.updateStatus("CF",basket .getId()) ;//CF = confirm

            // create payment transaction
            Payment payment = new Payment();
            payment.setId(formSave.getPaymentId());
            PaymentTransaction paymentTransaction = new PaymentTransaction(basket.getTotalAmount(),"N",null,basket,payment);
            paymentTransaction = paymentTransactionRepository.save(paymentTransaction);

            // create orders
           Integer id = ordersRepository.confirmOrder(paymentTransaction.getId());
//            orders.setId(id);
            return id;
        }catch (DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    public Optional<Orders> findById(int id){
        Optional<Orders> orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            return  orders;
        }
        throw  new BaseNotFoundException(Orders.class.getSimpleName()+" id = "+id);
    }

}
