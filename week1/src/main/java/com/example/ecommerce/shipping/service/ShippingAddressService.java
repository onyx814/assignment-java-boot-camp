package com.example.ecommerce.shipping.service;

import com.example.ecommerce.basket.repository.BasketRepository;
import com.example.ecommerce.shipping.model.ShippingAddress;
import com.example.ecommerce.shipping.model.ShippingAddressBasketReq;
import com.example.ecommerce.shipping.repository.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShippingAddressService {
    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    @Autowired
    BasketRepository basketRepository;

    @Transactional
    public Boolean createShippingAddress(ShippingAddressBasketReq item) throws  Exception {
        try {

            // create shipping address
            ShippingAddress dummy = item.getShippingAddress();
            ShippingAddress itemSave = new ShippingAddress(dummy.getAddress(), dummy.getPostcode(), dummy.getDistrict(), dummy.getProvince(), dummy.getTel());
            itemSave = shippingAddressRepository.save(itemSave);

            //call update basket
            basketRepository.updateShippingAddress(item.getBasketId(), itemSave.getId());
            return  Boolean.TRUE;
        } catch (DataAccessException ex) {
            throw new RuntimeException("createShippingAddress fail");
        } catch (Exception e) {
            throw new Exception("create shipping address fail");
        }

    }


}
