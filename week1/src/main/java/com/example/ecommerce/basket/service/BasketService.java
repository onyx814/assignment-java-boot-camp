package com.example.ecommerce.basket.service;

import com.example.ecommerce.basket.model.Basket;
import com.example.ecommerce.basket.model.BasketItem;
import com.example.ecommerce.basket.model.RequestBasketCreate;
import com.example.ecommerce.basket.repository.BasketItemRepository;
import com.example.ecommerce.basket.repository.BasketRepository;
import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.member.model.User;
import com.example.ecommerce.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    BasketItemRepository basketItemRepository;


    @Transactional
    public Integer createBasket(RequestBasketCreate item) throws  Exception {
        Basket basket =  new Basket();
        try {

            Product product = item.getProduct();

            // price ราคา product ที่ซื้อได้ในขณะนั้น , quantity จำนวนที่หยิบใส่ตะกร้า ไม่ใช่ จำนวนสินค้าทั้งหมด
            BigDecimal totalAmt = product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));

            // create basket
            User user = new User();
            user.setId(item.getUserId());
            basket.setUser(user);
            basket.setTotalAmount(totalAmt);
            basketRepository.save(basket);

            // create basket item
            BasketItem basketItem = new BasketItem(product.getPrice(),product.getQuantity(),totalAmt,basket,product);
            basketItemRepository.save(basketItem);

        }catch (Exception e){
            throw new Exception(this.getClass().getMethods()+"is fail.");
        }
        return  basket.getId();
    }

    public  Optional<Basket> findById(int id){

        Optional<Basket> result = basketRepository.findById(id);
        if(result.isPresent()){
            return  result;
        }
        throw  new BaseNotFoundException(Basket.class.getSimpleName()+" Id = "+id);
    }

    @Transactional
    public  Boolean updateStatus(int id , String status) throws Exception {
        boolean isSuccess = false;
        try {
            /* CO: checkout, CF: confirm, CN: cancel(ยังไม่ทำ cancel ใน รอบนี้ ) */
            if(!("CO".equals(status)||"CF".equals(status))){
                isSuccess = false;
                throw  new Exception(" status invalid!");
            }
            basketRepository.updateStatus(status,id);
            isSuccess =true;
        }catch (Exception e){

            throw  new Exception("update status not success");
        }
        return isSuccess;

    }



}
