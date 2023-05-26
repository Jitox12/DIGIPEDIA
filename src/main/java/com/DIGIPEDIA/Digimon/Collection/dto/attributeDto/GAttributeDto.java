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
public class GAttributeDto {
    private Integer attributeIdDto;
    private String attributeNameDto;
    @Lob
    private byte[] attributeImgDto;
}
