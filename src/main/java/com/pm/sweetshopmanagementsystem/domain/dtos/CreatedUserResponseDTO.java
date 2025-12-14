package com.pm.sweetshopmanagementsystem.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserResponseDTO {

    private UUID id;
    private String name;
    private String email;
}
