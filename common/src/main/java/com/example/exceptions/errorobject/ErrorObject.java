package com.example.exceptions.errorobject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {
    private String message;
    private String field;
    private String parameter;
}
