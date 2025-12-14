package com.pm.sweetshopmanagementsystem.mapper;


import com.pm.sweetshopmanagementsystem.domain.dtos.SweetCreateRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.SweetResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.entity.Sweet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SweetMapper {

    SweetResponseDTO toDto(Sweet sweet);

    @Mapping(target = "id", ignore = true)
    Sweet toSweetEntity(SweetCreateRequestDTO requestDTO);

    List<SweetResponseDTO> toDtoList(List<Sweet> sweets);



}
