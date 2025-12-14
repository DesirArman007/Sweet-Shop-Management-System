package com.pm.sweetshopmanagementsystem.domain.dtos;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestDTO {
    @Min(1)
    private int quantity;
}
