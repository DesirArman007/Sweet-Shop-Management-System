package com.pm.sweetshopmanagementsystem.services.impl;

import com.pm.sweetshopmanagementsystem.domain.dtos.SweetCreateRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetUpdateRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.entity.Sweet;
import com.pm.sweetshopmanagementsystem.mapper.SweetMapper;
import com.pm.sweetshopmanagementsystem.repositories.SweetRepository;
import com.pm.sweetshopmanagementsystem.services.SweetService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SweetServiceImpl implements SweetService {

    final SweetMapper sweetMapper;
    final SweetRepository sweetRepository;


    @Override
    public SweetResponseDTO createSweet(SweetCreateRequestDTO requestDTO) {
        Sweet sweet = new Sweet();
        sweet.setName(requestDTO.getName());
        sweet.setCategory(requestDTO.getCategory());
        sweet.setPrice(requestDTO.getPrice());
        sweet.setQuantity(requestDTO.getQuantity());

        sweetRepository.save(sweet);

        return sweetMapper.toDto(sweet);
    }

    @Override
    public List<SweetResponseDTO> getAllSweets() {
        List<Sweet> sweetList = sweetRepository.findAll();

        List<SweetResponseDTO> sweetResponseDTOList = sweetList.stream().map( sweet -> sweetMapper.toDto(sweet)).toList();

        return sweetResponseDTOList;
    }

    @Override
    public List<SweetResponseDTO> searchSweets(
            String name,
            String category,
            BigDecimal minPrice,
            BigDecimal maxPrice
    ) {

        List<Sweet> sweets;

        if (name != null && !name.isBlank()) {
            sweets = sweetRepository.findByNameContainingIgnoreCase(name);

        } else if (category != null && !category.isBlank()) {
            sweets = sweetRepository.findByCategoryIgnoreCase(category);

        } else if (minPrice != null && maxPrice != null) {
            sweets = sweetRepository.findByPriceBetween(minPrice, maxPrice);

        } else {
            sweets = sweetRepository.findAll();
        }

        return sweets.stream()
                .map(sweetMapper::toDto)
                .toList();
    }


    @Override
    public SweetResponseDTO updateSweet(UUID id, SweetUpdateRequestDTO updateRequestDTO) {
        Sweet existingSweet = sweetRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Sweet not found with id: "+id));

        existingSweet.setName(updateRequestDTO.getName());
        existingSweet.setCategory(updateRequestDTO.getCategory());
        existingSweet.setPrice(updateRequestDTO.getPrice());
        existingSweet.setQuantity(updateRequestDTO.getQuantity());

        sweetRepository.save(existingSweet);

        return sweetMapper.toDto(existingSweet);
    }

    @Override
    public void deleteSweet(UUID sweetId) {
        Sweet sweet = sweetRepository.findById(sweetId)
                        .orElseThrow( () -> new RuntimeException("Sweet not found") );
         sweetRepository.delete(sweet);
    }

    @Override
    @Transactional
    public SweetResponseDTO purchaseSweet(UUID sweetId, int quantity) {

        Sweet sweet = sweetRepository.findById(sweetId)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        if (sweet.getQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock available");
        }

        sweet.setQuantity(sweet.getQuantity() - quantity);

        sweetRepository.save(sweet);

        return sweetMapper.toDto(sweet);
    }

    @Override
    @Transactional
    public SweetResponseDTO restockSweet(UUID sweetId, int quantity) {

        Sweet sweet = sweetRepository.findById(sweetId)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setQuantity(sweet.getQuantity() + quantity);

        sweetRepository.save(sweet);

        return sweetMapper.toDto(sweet);
    }


}
