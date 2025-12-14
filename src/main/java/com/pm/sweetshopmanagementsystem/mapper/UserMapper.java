package com.pm.sweetshopmanagementsystem.mapper;


import com.pm.sweetshopmanagementsystem.domain.dtos.CreatedUserResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.RegisterRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    CreatedUserResponseDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    @Mapping(target = "hashPassword", ignore = true)
    User toUser(RegisterRequestDTO registerRequestDTO);


}
