package com.example.impl.entity.bank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class BancoDoBrasil implements PaymentStrategy {
    @Override
    public BankName getBankName() {
        return BankName.BB;
    }

    @Override
    public Double pay(Double amount) {
        return 1.79 * amount;
    }
}
