package com.pm.sweetshopmanagementsystem.config;

import com.pm.sweetshopmanagementsystem.domain.entity.User;
import com.pm.sweetshopmanagementsystem.enums.UserType;
import com.pm.sweetshopmanagementsystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Profile({"dev", "local"}) // runs only in dev/local
public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminIfNotExists() {

        String adminEmail = "admin@sweetshop.com";

        if (userRepository.findByEmail(adminEmail).isPresent()) {
            return;
        }

        User admin = User.builder()
                .name("Admin")
                .email(adminEmail)
                .hashPassword(passwordEncoder.encode("Admin@123"))
                .userType(UserType.ADMIN)
                .build();

        userRepository.save(admin);
    }
}
