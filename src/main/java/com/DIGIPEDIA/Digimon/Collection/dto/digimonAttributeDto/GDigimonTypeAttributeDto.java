package com.DIGIPEDIA.Digimon.Collection.dto.digimonAttributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GDigimonTypeAttributeDto {

    private String digimonTypeAttributeIdDto;
    private Integer digimonTypeIdDto;
    private Integer attributeIdDto;
    private String digimonTypeAttributeNameDto;
    private byte[] digimonTypeAttributeImg;
}
