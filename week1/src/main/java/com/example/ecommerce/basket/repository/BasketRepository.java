package com.example.ecommerce.basket.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.example.ecommerce.basket.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    Optional<Basket> findById(int id);

    @Modifying
    @Query(value = "update basket b set b.status = :status where b.id = :id", nativeQuery = true)
    int updateStatus( @Param(value = "status") String status , @Param(value = "id") int id);


    @Modifying
    @Query(value = "update basket b set b.shipping_address_id = :shipping_address_id where b.id = :id", nativeQuery = true)
    int updateShippingAddress(@Param(value="id") int id, @Param(value = "shipping_address_id") int shippingAddressId);
}
