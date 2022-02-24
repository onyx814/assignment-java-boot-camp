package com.example.ecommerce.member.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.member.model.Address;
import com.example.ecommerce.member.model.User;
import com.example.ecommerce.member.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(int id){
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return  result;
        }
        throw  new BaseNotFoundException(User.class.getSimpleName()+" id = "+ id);
    }


}
