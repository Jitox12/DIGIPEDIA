package com.DIGIPEDIA.Digimon.Collection.dto.digimonAttributeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonTypeAttributeDto {
    private String digimonTypeAttributeIdDto;
    private Integer digimonTypeIdDto;
    private Integer attributeIdDto;
    private String digimonTypeAttributeNameDto;
    private byte[] digimonTypeAttributeImgDto;
    private List<GADigimonDto> digimonsDto;
}
