package com.example.impl.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Bradesco implements PaymentStrategy {
    @Override
    public BankName getBankName() {
        return BankName.BRADESCO;
    }

    @Override
    public Double pay(Double amount) {
        return 1.72 * amount;
    }
}
