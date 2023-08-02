package com.meva.finance.api.dto;


import com.meva.finance.api.model.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String cpf;
    private String name;
    private String genre;
    private Date birth;
    private String state;
    private String city;
    private FamilyDto familyDto;

    //modo de converter
    public User converter(UserDto userDto) {
     return User.builder().birth(birth).name(name).cpf(cpf).genre(genre).state(state).city(city).build();
    }

    public User update(UserDto userDto) {
       return User.builder().birth(birth).name(name).cpf(cpf).genre(genre).state(state).city(city).family(familyDto.converter(familyDto)).build();
    }
}

