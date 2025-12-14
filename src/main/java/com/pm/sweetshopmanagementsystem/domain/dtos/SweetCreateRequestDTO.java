package com.pm.sweetshopmanagementsystem.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
