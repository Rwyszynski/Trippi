package com.trippi.trippiApp.service;

import com.trippi.trippiApp.dto.RegistrationDto;
import entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findByEmail(String email);
    User findByUsername(String username);
}
