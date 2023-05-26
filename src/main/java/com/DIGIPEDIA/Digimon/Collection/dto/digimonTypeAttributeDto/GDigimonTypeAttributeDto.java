package com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GDigimonTypeAttributeDto {

    private String digimonTypeAttributeIdDto;
    private String digimonTypeAttributeNameDto;
    @Lob
    private byte[] digimonTypeAttributeImgDto;
}