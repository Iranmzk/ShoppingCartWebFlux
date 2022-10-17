package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentPrice {
    private Double price;
    private String currencyUnit;
}
