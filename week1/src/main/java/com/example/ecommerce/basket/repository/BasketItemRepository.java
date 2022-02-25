package com.example.ecommerce.basket.repository;

import com.example.ecommerce.basket.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Integer> {


}
