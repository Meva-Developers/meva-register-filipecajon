package com.meva.finance.api.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String cpf;
    private String name;
    private String genre;
    private Date birth;
    private String state;
    private String city;
    private FamilyDto familyDto;
}
