package com.example.jpaEcommerceServer.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterValueAmount {
    private String value;
    private int amount;
}
