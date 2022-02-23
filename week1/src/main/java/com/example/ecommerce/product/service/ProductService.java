package com.example.ecommerce.product.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) { // for service test
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        List<Product> list = productRepository.findAll();
        if(list.isEmpty()){
            throw new BaseNotFoundException("Product");
        }
        return list;
    }

    public List<Product> findByName(String name){
        List<Product> list = productRepository.findByNameContaining(name);
        if(list.isEmpty()){
            throw new BaseNotFoundException("Product");
        }
        return list;
    }

    public  Optional<Product> findById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return  product;
        }
        throw  new BaseNotFoundException(Product.class.getSimpleName());
    }

}
