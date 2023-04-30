package com.DIGIPEDIA.Digimon.Collection.dto.attributeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonAttributeDto.GDigimonTypeAttributeDto;
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
public class GAttributeDto {
    private Integer attributeIdDto;
    private String attributeNameDto;
    private List<GDigimonTypeAttributeDto> digimonTypeAttributeDto;
    private List<GSkillDto> skillsDto;
}
