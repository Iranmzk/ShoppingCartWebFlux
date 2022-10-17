package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String usItemId;
    private String name;
    private String segment;
    private String type;
    private PriceInfo price;
    @JsonProperty("shortDescription")
    private String description;
}
