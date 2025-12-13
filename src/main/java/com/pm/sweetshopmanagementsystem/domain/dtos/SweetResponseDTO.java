package com.pm.sweetshopmanagementsystem.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@Getter
public class SweetResponseDTO {

    private UUID id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;
}
