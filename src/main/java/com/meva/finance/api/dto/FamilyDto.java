package com.meva.finance.api.dto;

import com.meva.finance.api.model.Family;
import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamilyDto {
    private Long idFamily;
    private String description;


    public Family converter(FamilyDto familyDto) {
        return Family.builder().idFamily(idFamily).description(description).build();
    }
}