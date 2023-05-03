package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GAAttributeDto {
    private Integer attributeIdDto;
    private String attributeNameDto;
    private byte[] attributeImgDto;
    private List<GDigimonTypeAttributeDto> digimonTypesAttributeDto;
    private List<GSkillDto> skillsDto;
}