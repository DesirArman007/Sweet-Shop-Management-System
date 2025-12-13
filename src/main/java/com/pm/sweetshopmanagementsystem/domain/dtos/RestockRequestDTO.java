package com.pm.sweetshopmanagementsystem.domain.dtos;

import jakarta.validation.constraints.Min;

public class RestockRequestDTO {

    @Min(1)
    private int quantity;

}
