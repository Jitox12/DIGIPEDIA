package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GAttributeDto {
    private Integer attributeIdDto;
    private String attributeNameDto;
    private byte[] attributeImgDto;
}
