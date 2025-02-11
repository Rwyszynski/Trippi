package com.trippi.trippiApp.service.impl;

import com.trippi.trippiApp.dto.RegistrationDto;
import com.trippi.trippiApp.entity.Language;
import com.trippi.trippiApp.repository.LanguageRepository;
import com.trippi.trippiApp.repository.RoleRepository;
import com.trippi.trippiApp.repository.UserRepository;
import com.trippi.trippiApp.search.UserSpecification;
import com.trippi.trippiApp.service.UserService;
import com.trippi.trippiApp.entity.Role;
import com.trippi.trippiApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private LanguageRepository languageRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, LanguageRepository languageRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.languageRepository = languageRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setNickName(registrationDto.getNickName());
        user.setEmail(registrationDto.getEmail());
        user.setLastName(registrationDto.getLastName());
        user.setSex(registrationDto.getSex());
        user.setAge(registrationDto.getAge());
        user.setCountry(registrationDto.getCountry());
        user.setCity(registrationDto.getCity());

        List<Language> languages = languageRepository.findAll();
        user.setLanguages(languages);

        user.setIdNumber(registrationDto.getIdNumber());
        user.setDescription(registrationDto.getDescription());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public List<User> searchUsers(String nickname, String country) {
        return userRepository.searchUsers(nickname, country);

    }
}
