package com.DIGIPEDIA.Digimon.Collection.dto.skillDto;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GASkillDto {
    private Integer skillIdDto;
    private String skillNameDto;
    private String skillDescriptionDto;
    private GSkillTypeDto skillTypeDto;
    private GAttributeDto attributeDto;
    private List<GDigimonDto> digimonsDto;

}