package com.pm.sweetshopmanagementsystem.domain.dtos;

import jakarta.validation.constraints.Min;

public class PurchaseRequestDTO {
    @Min(1)
    private int quantity;
}
