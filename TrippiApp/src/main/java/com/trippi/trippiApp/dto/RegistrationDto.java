package com.trippi.trippiApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegistrationDto {

    private Long id;
    @NotEmpty
    private String nickName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String lastName;
    private String sex;
    private int age;
    private String country;
    private String city;
    private List<Long> languagesIds = new ArrayList<>();
    private String idNumber;
    private String description;

}
