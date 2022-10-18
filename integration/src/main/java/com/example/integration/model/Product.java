package com.example.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String usItemId;
    private String name;
    private String segment;
    private String type;
    private PriceInfo priceInfo;
    @JsonProperty("shortDescription")
    private String description;
}
