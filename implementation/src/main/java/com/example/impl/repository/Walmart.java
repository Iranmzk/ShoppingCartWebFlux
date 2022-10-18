package com.example.impl.repository;

import com.example.impl.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Walmart extends ReactiveMongoRepository<ShoppingCart,String> {
}
