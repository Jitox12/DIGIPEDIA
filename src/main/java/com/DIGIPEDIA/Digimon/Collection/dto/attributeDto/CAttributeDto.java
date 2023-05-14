package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CAttributeDto {
    private String attributeNameDto;
    @Lob
    private byte[] attributeImgDto;
}