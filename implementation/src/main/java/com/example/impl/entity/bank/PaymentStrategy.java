package com.example.impl.entity.bank;

public interface PaymentStrategy {

    BankName getBankName();
    Double pay(Double amount);
}
