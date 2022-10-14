package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseData {
    private Product product;
}
