package com.example.impl.entity.bank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Santander implements PaymentStrategy {
    @Override
    public BankName getBankName() {
        return BankName.SANTANDER;
    }

    @Override
    public Double pay(Double amount) {
        return 1.68 * amount;
    }
}
