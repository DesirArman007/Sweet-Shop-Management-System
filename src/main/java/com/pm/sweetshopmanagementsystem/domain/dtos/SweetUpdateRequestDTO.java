package com.pm.sweetshopmanagementsystem.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SweetUpdateRequestDTO {
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;
}
