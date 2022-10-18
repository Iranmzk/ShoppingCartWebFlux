package com.example.impl.service.mapper;

import com.example.impl.entity.ShoppingCart;
import com.example.integration.model.Data;

public class DataToEntity {

    public static ShoppingCart dataToEntity(Data integration){
        var product = integration.getData().getProduct();
        var currentPrice = integration.getData().getProduct().getPriceInfo();

        return ShoppingCart.builder()
                .usItemId(product.getUsItemId())
                .name(product.getName())
                .segment(product.getSegment())
                .type(product.getType())
                .price(currentPrice.getCurrentPrice().getPrice())
                .description(product.getDescription())
                .build();
    }
}
