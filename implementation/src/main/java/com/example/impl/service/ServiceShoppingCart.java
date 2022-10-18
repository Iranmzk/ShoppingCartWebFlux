package com.example.impl.service;

import com.example.impl.entity.bank.StrategyContext;
import com.example.impl.repository.Walmart;
import com.example.impl.service.mapper.DataToEntity;
import com.example.impl.service.mapper.ShoppingCartMapper;
import com.example.impl.service.model.Request;
import com.example.impl.service.model.Response;
import com.example.integration.WalmartIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ServiceShoppingCart {

    private final Walmart repository;
    private final WalmartIntegration integration;
    private final StrategyContext context;

    public Mono<Response> test(String usItemId) {
        return repository.findById(usItemId)
                .map(ShoppingCartMapper::entityToResponse);
    }

    public Mono<Response> findIntegration(String usItemId, Request request) {
        var strategyContext = context.paidWithTax(ShoppingCartMapper.requestToEntity(request));

        return integration.findProductsDetails(usItemId)
                .map(DataToEntity::dataToEntity)
                .flatMap(repository::save)
                .map(ShoppingCartMapper::entityToResponse);
    }
}
