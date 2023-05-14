package com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CDigimonTypeAttributeDto {
    private Integer digimonTypeIdDto;
    private Integer attributeIdDto;
    private byte[] digimonTypeAttributeImgDto;
    private String digimonTypeAttributeNameDto;
}