package com.example.impl.entity.bank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Itau implements PaymentStrategy{
    @Override
    public BankName getBankName() {
        return BankName.ITAU;
    }

    @Override
    public Double pay(Double amount) {
        return 1.55 * amount;
    }
}
