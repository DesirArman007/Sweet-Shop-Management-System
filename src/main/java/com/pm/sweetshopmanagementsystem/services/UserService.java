package com.pm.sweetshopmanagementsystem.services;


import com.pm.sweetshopmanagementsystem.domain.dtos.CreatedUserResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.RegisterRequestDTO;

public interface UserService {

    CreatedUserResponseDTO registerUser(RegisterRequestDTO registerRequestDTO);

    LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);

}
