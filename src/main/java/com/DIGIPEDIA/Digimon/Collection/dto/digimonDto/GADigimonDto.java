package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonAttributeDto.GDigimonTypeAttributeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonDto {

    private Integer digimonIdDto;
    private Integer digimonMemoryDto;
    private String digimonNameDto;
    private byte[] digimonImgDto;
    private String digimonPassiveDto;
    private String digimonFamilyDto;
    private GDigimonTypeAttributeDto digimonTypeAttributeDto;
    private List<String> skillsDto;
}
