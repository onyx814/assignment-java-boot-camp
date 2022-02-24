package com.example.ecommerce.member.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.member.model.Address;
import com.example.ecommerce.member.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Optional<Address> findDefaultAddressByUserId(int id){
        Optional<Address> result = addressRepository.findByDefaultShippingAndUserId("Y",id);
        if(result.isPresent()){
            return  result;
        }
        throw  new BaseNotFoundException(Address.class.getSimpleName());
    }

    /* not use
    public List<Address> findAll(){
        List<Address> result = addressRepository.findAll();
        if(!result.isEmpty()){
            return  result;
        }
        throw  new BaseNotFoundException(Address.class.getSimpleName());
    }
    */



}
