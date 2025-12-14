package com.pm.sweetshopmanagementsystem.domain.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SweetResponseDTO {

    private UUID id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;
}
