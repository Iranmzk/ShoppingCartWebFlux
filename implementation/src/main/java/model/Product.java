package model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Product {
    @Id
    private String usItemId;
    private String name;
    private String segment;
    private String type;
    private String price;
    private String description;
}
