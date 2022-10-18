package com.example.impl.entity.bank;

import com.example.impl.entity.ShoppingCart;
import com.example.impl.service.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor

public class StrategyContext implements InitializingBean {

    private final List<PaymentStrategy> paymentStrategyList;
    private Map<BankName, PaymentStrategy> strategyMap;

    @Override
    public void afterPropertiesSet() {
        this.strategyMap = new EnumMap<>(BankName.class);
        paymentStrategyList.forEach((PaymentStrategy strategy) ->
                strategyMap.put(strategy.getBankName(), strategy));
    }

    public Mono<ShoppingCart> paidWithTax(ShoppingCart entity){
        var getName= strategyMap.get(entity.getBankName());
        var total= getName.pay(entity.getPrice());
        entity.setPrice(total);

        return Mono.just(entity);
    }

    public Mono<Response> paidWithTax(Response response){
        var getName= strategyMap.get(response.getBankName());
        var total= getName.pay(response.getPrice());
        response.setPrice(total);

        return Mono.just(response);
    }
}
