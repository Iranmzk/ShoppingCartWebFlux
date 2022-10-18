package com.example.impl.service.model;

import com.example.impl.entity.bank.BankName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private String usItemId;
    private String name;
    private String segment;
    private String type;
    private Double price;
    private String description;
    private BankName bankName;
}
