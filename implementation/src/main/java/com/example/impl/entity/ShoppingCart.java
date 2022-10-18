package com.example.impl.entity;

import com.example.impl.entity.bank.BankName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCart {
    @Id
    private String usItemId;
    private String name;
    private String segment;
    private String type;
    private Double price;
    private String description;
    private BankName bankName;
}
