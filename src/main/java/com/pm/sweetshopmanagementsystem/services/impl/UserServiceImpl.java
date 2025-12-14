package com.pm.sweetshopmanagementsystem.services.impl;

import com.pm.sweetshopmanagementsystem.config.JwtService;
import com.pm.sweetshopmanagementsystem.domain.dtos.CreatedUserResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.LoginResponseDTO;
import com.pm.sweetshopmanagementsystem.domain.dtos.RegisterRequestDTO;
import com.pm.sweetshopmanagementsystem.domain.entity.User;
import com.pm.sweetshopmanagementsystem.enums.UserType;
import com.pm.sweetshopmanagementsystem.mapper.UserMapper;
import com.pm.sweetshopmanagementsystem.repositories.UserRepository;
import com.pm.sweetshopmanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public CreatedUserResponseDTO RegisterUser(RegisterRequestDTO registerRequestDTO) {
        userRepository.findByEmail(registerRequestDTO.getEmail()).ifPresent(user ->{
            throw new IllegalStateException("User with email " + registerRequestDTO.getEmail() + " already exists.");
        });

        User user = userMapper.toUser(registerRequestDTO);
        user.setHashPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setUserType(UserType.USER);

        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public LoginResponseDTO LoginUser(LoginRequestDTO loginRequestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new LoginResponseDTO(
                jwtService.generateToken(user),
                jwtService.generateRefreshToken(user)
        );

    }


}
