package com.pm.sweetshopmanagementsystem.services;

import com.pm.sweetshopmanagementsystem.domain.dtos.SweetCreateRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetUpdateRequestDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface SweetService {

    SweetResponseDTO createSweet(SweetCreateRequestDTO requestDTO);

    List<SweetResponseDTO> getAllSweets();

    List<SweetResponseDTO> searchSweets(
            String name,
            String Category,
            BigDecimal minPrice,
            BigDecimal maxPrice
    );

    SweetResponseDTO updateSweet(UUID Id, SweetUpdateRequestDTO requestDTO);

    void deleteSweet(UUID sweetId);

}
