package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CAttributeDto {
    private String attributeNameDto;
    @Lob
    private byte[] attributeImgDto;
}