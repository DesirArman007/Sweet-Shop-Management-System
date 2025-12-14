package com.pm.sweetshopmanagementsystem.controllers;

import com.pm.sweetshopmanagementsystem.domain.dtos.SweetCreateRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetUpdateRequestDTO;
import com.pm.sweetshopmanagementsystem.services.SweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/sweets")
@RequiredArgsConstructor
public class SweetController {

    private final SweetService sweetService;

    @PostMapping
    public ResponseEntity<SweetResponseDTO> addNewSweet(@RequestBody @Valid SweetCreateRequestDTO requestDTO){
        SweetResponseDTO responseDTO = sweetService.createSweet(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SweetResponseDTO>> getAllSweets(){
        List<SweetResponseDTO> sweetResponseDTOList = sweetService.getAllSweets();

        return ResponseEntity.ok(sweetResponseDTOList);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<SweetResponseDTO>> searchSweets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice
    ){
        List<SweetResponseDTO> searchResult = sweetService.searchSweets(name,category,minPrice,maxPrice);
        return ResponseEntity.ok(searchResult);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<SweetResponseDTO> updateSweet(@PathVariable UUID id,
                                                        @RequestBody SweetUpdateRequestDTO updateRequestDTO){
        SweetResponseDTO updatedSweet = sweetService.updateSweet(id, updateRequestDTO);

        return ResponseEntity.ok(updatedSweet);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSweet( @PathVariable UUID id){
        sweetService.deleteSweet(id);

        return ResponseEntity.noContent().build();
    }


    @PostMapping(path = "/{id}/purchase")
    public ResponseEntity<SweetResponseDTO> purchaseSweet(
            @PathVariable UUID id,
            @RequestParam int quantity
    ){
        SweetResponseDTO purchasedQuantity = sweetService.purchaseSweet(id, quantity);

        return ResponseEntity.ok(purchasedQuantity);
    }

    @PostMapping(path = "/{id}/restock")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SweetResponseDTO> restockSweet(
            @PathVariable UUID id,
            @RequestParam int quantity
    ){
        SweetResponseDTO restockedSweet = sweetService.restockSweet(id, quantity);

        return ResponseEntity.ok(restockedSweet);

    }



}
