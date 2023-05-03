package com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CDigimonTypeAttributeDto {
    private Integer digimonTypeIdDto;
    private Integer attributeIdDto;
    private byte[] digimonTypeAttributeImgDto;
    private String digimonTypeAttributeNameDto;
}