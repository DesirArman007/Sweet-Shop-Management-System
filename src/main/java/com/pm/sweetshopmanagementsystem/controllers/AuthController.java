package com.pm.sweetshopmanagementsystem.controllers;

import com.pm.sweetshopmanagementsystem.domain.dtos.CreatedUserResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.RegisterRequestDTO;
import com.pm.sweetshopmanagementsystem.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<CreatedUserResponseDTO> registerUser ( @RequestBody @Valid RegisterRequestDTO registerRequestDTO){
        CreatedUserResponseDTO registerUserDto = userService.registerUser(registerRequestDTO);
        return new ResponseEntity<>(registerUserDto, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        LoginResponseDTO loginResponseDTO = userService.loginUser(loginRequestDTO);
        return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
    }
}
