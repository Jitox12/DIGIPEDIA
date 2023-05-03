package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GDigimonDto {
    private Integer digimonIdDto;
    private Integer digimonMemoryDto;
    private String digimonNameDto;
    private byte[] digimonImgDto;
    private String digimonPassiveDto;
    private GDigimonFamilyDto digimonFamilyDto;
    private GDigimonTypeAttributeDto digimonTypeAttributeDto;
}
