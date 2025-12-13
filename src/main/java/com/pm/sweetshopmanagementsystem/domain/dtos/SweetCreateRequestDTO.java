package com.pm.sweetshopmanagementsystem.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class SweetCreateRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank
    private String category;

    @Positive
    private BigDecimal price;

    @Min(0)
    private int quantity;
}
