package com.trippi.trippiApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegistrationDto {

    private Long id;
    @NotEmpty(message = "Pole Nick nie może być puste")
    private String nickName;
    @NotEmpty(message = "Pole email nie może być puste")
    private String email;
    @NotEmpty(message = "Pole Hasło nie może być puste")
    private String password;
    @NotEmpty(message = "Pole Imię nie może być puste")
    private String userName;
    @NotEmpty(message = "Pole Nazwisko nie może być puste")
    private String lastName;
    private String sex;
    private int age;
    private String country;
    private String city;
    private List<Long> languagesIds = new ArrayList<>();
    private String idNumber;
    private String description;

}
