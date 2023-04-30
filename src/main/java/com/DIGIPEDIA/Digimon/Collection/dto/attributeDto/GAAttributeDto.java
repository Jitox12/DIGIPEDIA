package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GAAttributeDto {
    private Integer attributeIdDto;
    private String attributeNameDto;
    private List<String> digimonTypesNameDto;
    private List<String> skillsNameDto;
}